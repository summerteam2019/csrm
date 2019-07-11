package com.kb.csrm.imoocCrawler.util;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Objects;

/**
 * HTTPClient工具类
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/07/08
 */
@Slf4j
public class HttpUtil {

	private final static Logger log = LoggerFactory.getLogger(HttpUtil.class);
	
	private RequestConfig requestConfig = RequestConfig.custom()  
            .setSocketTimeout(Constraints.TIME_OUT)  
            .setConnectTimeout(Constraints.TIME_OUT)  
            .setConnectionRequestTimeout(Constraints.TIME_OUT)  
            .build();  
      
    private HttpUtil(){} 
    
    public static HttpUtil getInstance(){  
        return InstanceHolder.INSTANCE.getUtil();
    }  
    
    /**
     * 实现单例用的枚举
     * @author yanrun
     *
     */
    private enum InstanceHolder {
    	INSTANCE;
    	private HttpUtil util;
    	
    	private InstanceHolder() {
    		util = new HttpUtil();
    	}
    	
    	private HttpUtil getUtil() {
    		return util;
    	}
    }
	
    /**
     * 发送GET请求
     * @param url 目标URL
     * @return
     */
	public String sendHttpGet(String url) {
		return sendHttpGet(new HttpGet(url));
	}

	private String sendHttpGet(HttpGet httpGet) {
		httpGet.setConfig(requestConfig);
		httpGet.setHeader("User-Agent", Constraints.USER_AGENT);
		httpGet.setHeader("Connection", "Keep-Alive");
		try {
			CloseableHttpClient httpClient = HttpClientPoolUtil.getInstance().getHttpClient();
			String responseBody = "";
			if(!Objects.isNull(httpClient)) {
				@Cleanup CloseableHttpResponse response = httpClient.execute(httpGet);
				ResponseHandler<String> responseHandler = new BasicResponseHandler();  
				responseBody = httpClient.execute(httpGet, responseHandler);
			}
			return responseBody;
		} catch(SocketTimeoutException e) {
			// 服务器请求超时
			log.error("服务器请求超时");
		} catch(ConnectTimeoutException e) {
			// 服务器响应超时(已经请求了)
			log.error("服务器响应超时");
		} catch(UnknownHostException e) {
			log.error("无网络连接或无法识别的主机");
		} catch(Exception e) {
			log.error(e.getMessage());
		}
		return "";
	}

}
