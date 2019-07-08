package com.kb.csrm.imoocCrawler.util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.kb.csrm.course.dto.CourseDto;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HTML解析类
 * @author yanrun
 *
 */
@Slf4j
public class HtmlParser {

	private  final static Logger log = LoggerFactory.getLogger(HtmlParser.class);
	
	private final String TARGET_URL;
	private final HttpUtil HTTP_UTIL;
	private Document doc;
	private ThreadLocal<Map<String, String>> imgUrlThreadLocal;
	private ThreadLocal<Map<String, Object>> parseResultThreadLocal;

	private HtmlParser(String url){
		this.TARGET_URL = url;
		this.HTTP_UTIL = HttpUtil.getInstance();
		String htmlString = getHtmlString(url);
		if(!StringUtils.isEmpty(htmlString)) {
			doc = Jsoup.parse(htmlString);
		}	
		imgUrlThreadLocal = new ThreadLocal<>();
		imgUrlThreadLocal.set(new HashMap<>());
		parseResultThreadLocal = new ThreadLocal<>();
		parseResultThreadLocal.set(new HashMap<>());
	}
	
	public static HtmlParser getInstance(String url) {

		return new HtmlParser(url);
	}
	
	/**
	 * 检查传入的URL是否为慕课网的URL
	 * @param targetUrl 要检测的URL
	 * @return URL是否为慕课网的URL
	 */
	private static boolean checkHost(String targetUrl) {
		if(StringUtils.isEmpty(targetUrl)) {
			log.error("空的URL");
			return false;
		}
		targetUrl = StringUtils.lowerCase(targetUrl);
		String host;
		String path;
		if(!StringUtils.startsWithIgnoreCase(targetUrl, "http://") && !StringUtils.startsWithIgnoreCase(targetUrl, "https://")) {
			targetUrl = "http://".concat(targetUrl);
		}
		try {
			URL url = new URL(targetUrl);
			host = url.getHost();
			path = url.getPath();
		} catch(Exception e) {
			log.error("非法的URL");
			e.printStackTrace();
			return false;
		}
		return StringUtils.contains(host, "imooc.com") && StringUtils.contains(path, "course/list");
	}
	
	/**
	 * 根据url获取HTML源码
	 * @param url 目标url
	 * @return HTML源码
	 */
	private String getHtmlString(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建参数队列
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", "admin"));
		params.add(new BasicNameValuePair("password", "123456"));

		try {
			//参数转换为字符串
			String paramsStr = EntityUtils.toString(new UrlEncodedFormEntity(params, "UTF-8"));
			// 创建httpget.
			HttpGet httpget = new HttpGet(url);
			System.out.println("executing request " + httpget.getURI());
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				// 打印响应状态
				System.out.println(response.getStatusLine());
				if (entity != null) {
					// 打印响应内容长度
					System.out.println("Response content length: " + entity.getContentLength());
					// 打印响应内容
					System.out.println("Response content: " + EntityUtils.toString(entity));
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return HTTP_UTIL.sendHttpGet(url);
	}
	
	/**
	 * 解析HTML
	 * @return 解析获得的数据
	 */
	public Map<String, Object> parse() {
		Map<String, Object> resultMap = parseResultThreadLocal.get();
		Map<String, String> imgUrlMap = imgUrlThreadLocal.get();
		List<CourseDto> courseList = new LinkedList<>();
		courseList = Collections.synchronizedList(courseList);
		int pageIndex = getLastEqualsIndex(TARGET_URL);
		String fixedCourseUrl = StringUtils.substring(TARGET_URL, 0, pageIndex); //获取不变的URL
		int totalPages = getTotalPageNum();
		if(totalPages == 0) {
			return resultMap;
		}
		StringBuilder urlBuilder = new StringBuilder(fixedCourseUrl);
		Elements courseItems;
		String imgSrc;
		String courseName;
		String courseIntroduce;
		String teacherName;
		String collegeName;
		String staticURL = "http://www.imooc.com";
		CourseDto course = new CourseDto();
		String htmlStr;
		for(int pageNum = 1; pageNum <= totalPages; pageNum++) {
			log.info("正在处理第" + pageNum + "页,还有" + (totalPages - pageNum) + "页");
			urlBuilder = urlBuilder.append(pageNum);
			if(pageNum >= 2) {
				htmlStr = getHtmlString(urlBuilder.toString());
				if(htmlStr.isEmpty()) {
					continue;
				}
				doc = Jsoup.parse(htmlStr);
			}
			courseItems = doc.select(".container div .course-card-container");
			for(Element courseItem : courseItems) {
				imgSrc = "http:"+ courseItem.getElementsByTag("img").attr("data-original");
				courseName = courseItem.getElementsByClass("course-card-name").text();
				courseIntroduce = courseItem.getElementsByClass("course-card-desc").text();
				teacherName = "网络教师";
				collegeName = "慕课网";
				course = new CourseDto();
				course.setCourseName(courseName);
				course.setCourseIntroduce(courseIntroduce);
				course.setTeacherName(teacherName);
				course.setCollegeName(collegeName);
				courseList.add(course);
				imgUrlMap.put(courseName, imgSrc);
			}
			urlBuilder.delete(pageIndex, urlBuilder.length());
		}
		resultMap.put("courseList", courseList);
		resultMap.put("imgUrlMap", imgUrlMap);
		log.info("获取数据完成");
		parseResultThreadLocal.remove();
		imgUrlThreadLocal.remove();
		return resultMap;
	}
	
	/**
	 * 获取最后一个等号的位置
	 * @param str 源字符串
	 * @return 最后一个等号的位置
	 */
	private int getLastEqualsIndex(String str) {
		return StringUtils.lastIndexOf(str, "=") + 1;
	}
	
	/**
	 * 解析HTML获取页数
	 * @return 页数
	 */
	private int getTotalPageNum() {
		String errorMsg = "无法获取网页内容";
		try {
			if(Objects.isNull(doc)) {
				throw new RuntimeException(errorMsg);
			}
			Element lastPageElement = doc.select(".page a").last();
			String lastPageHref = (lastPageElement.getElementsByClass("active text-page-tag").isEmpty())
					? lastPageElement.attr("href") : lastPageElement.text();
			return Integer.parseInt(StringUtils.substring(lastPageHref, getLastEqualsIndex(lastPageHref)));
		} catch(Exception e) {
			String message = e.getMessage();
			if(StringUtils.equals(message, errorMsg)) {
				log.error(message);
			} else {
				e.printStackTrace();
			}
			return 0;
		}
	}
}
