package com.kb.csrm.imoocCrawler.util;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.Objects;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;

/**
 * HTTPClient连接池工具类
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */
public class HttpClientPoolUtil {

	private static int MAX_CONNECTION_NUM = 50; // 最大连接数50

	private static int MAX_PER_ROUTE = 10; // 单路由最大连接数10

	private static Object LOCAL_LOCK = new Object();

	private PoolingHttpClientConnectionManager cm = null;

	private static volatile HttpClientPoolUtil instance;

	private ConnectionKeepAliveStrategy keepAliveStrategy = new ConnectionKeepAliveStrategy() {

		@Override
		public long getKeepAliveDuration(HttpResponse response,
				HttpContext context) {
			HeaderElementIterator it = new BasicHeaderElementIterator(
					response.headerIterator(HTTP.CONN_KEEP_ALIVE));
			HeaderElement he;
			String param;
			String value;
			while (it.hasNext()) {
				he = it.nextElement();
				param = he.getName();
				value = he.getValue();
				if (!Objects.isNull(value)
						&& StringUtils.equalsIgnoreCase(param, "timeout")) {
					return Long.parseLong(value) * 1000;
				}
			}
			return 60 * 1000;// 如果没有约定，则默认定义时长为60s
		}
	};

	private HttpClientPoolUtil() {

	}

	public static HttpClientPoolUtil getInstance() {
		if (Objects.isNull(instance)) {
			synchronized (LOCAL_LOCK) {
				if (Objects.isNull(instance)) {
					instance = new HttpClientPoolUtil();
				}
			}
		}
		return instance;
	}

	private PoolingHttpClientConnectionManager getPoolManager() {
		if (Objects.isNull(cm)) {
			synchronized (LOCAL_LOCK) {
				if (Objects.isNull(cm)) {
					SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
					try {
						sslContextBuilder.loadTrustMaterial(null,
								new TrustSelfSignedStrategy());
						SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
								sslContextBuilder.build());
						Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
								.<ConnectionSocketFactory> create()
								.register("https", socketFactory)
								.register("http",
										new PlainConnectionSocketFactory())
								.build();
						cm = new PoolingHttpClientConnectionManager(
								socketFactoryRegistry);
						cm.setMaxTotal(MAX_CONNECTION_NUM);
						cm.setDefaultMaxPerRoute(MAX_PER_ROUTE);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return cm;
	}

	public CloseableHttpClient getHttpClient() {
		CloseableHttpClient httpClient = HttpClients.custom()
				.setKeepAliveStrategy(keepAliveStrategy)
				.setConnectionManager(getPoolManager())
				.setRetryHandler(retryHandler)
				.build();
		return httpClient;
	}

	// 请求重试处理
	private HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {

		@Override
		public boolean retryRequest(IOException exception, int executionCount,
				HttpContext context) {
			// 如果已经重试了5次，就放弃
			if (executionCount >= 5) {
				return false;
			}
			// 如果服务器丢掉了连接，那么就重试
			if (exception instanceof NoHttpResponseException) {
				return true;
			}
			// 不要重试SSL握手异常
			if (exception instanceof SSLHandshakeException) {
				return false;
			}
			// 超时
			if (exception instanceof InterruptedIOException) {
				return false;
			}
			// 目标服务器不可达
			if (exception instanceof UnknownHostException) {
				return false;
			}
			// 连接被拒绝
			if (exception instanceof ConnectTimeoutException) {
				return false;
			}
			// SSL握手异常
			if (exception instanceof SSLException) {
				return false;
			}

			HttpClientContext clientContext = HttpClientContext.adapt(context);
			HttpRequest request = clientContext.getRequest();
			// 如果请求是幂等的，就再次尝试
			if (!(request instanceof HttpEntityEnclosingRequest)) {
				return true;
			}
			return false;
		}
	};

}
