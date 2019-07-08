package com.kb.csrm.imoocCrawler;

import java.io.IOException;

import com.kb.csrm.imoocCrawler.crawler.Crawler;

/**
 * 
 * @author yanrun
 *
 */
public class App {
	/**
	 *　　　　　　　　┏┓　　　┏┓+ +
	 *　　　　　　　┏┛┻━━━┛┻┓ + +
	 *　　　　　　　┃　　　　　　　┃ 　
	 *　　　　　　　┃　　　━　　　┃ ++ + + +
	 *　　　　       	██ ━██  ┃+
	 *　　　　　　　┃　　　　　　　┃ +
	 *　　　　　　　┃　　　┻　　　┃
	 *　　　　　　　┃　　　　　　　┃ + +
	 *　　　　　　　┗━┓　　　┏━┛
	 *　　　　　　　　　┃　　　┃　　　　　　　　　　　
	 *　　　　　　　　　┃　　　┃ + + + +
	 *　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting　　　　　　　
	 *　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug　　
	 *　　　　　　　　　┃　　　┃
	 *　　　　　　　　　┃　　　┃　　+　　　　　　　　　
	 *　　　　　　　　　┃　 　　┗━━━┓ + +
	 *　　　　　　　　　┃ 　　　　　　　┣┓
	 *　　　　　　　　　┃ 　　　　　　　┏┛
	 *　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
	 *　　　　　　　　　　┃┫┫　┃┫┫
	 *　　　　　　　　　　┗┻┛　┗┻┛+ + + +
	 */
	public static void main(String[] args) throws IOException {
    	Crawler.Builder crawlerBuilder = new Crawler.Builder();
    	Crawler crawler = crawlerBuilder
    			.print(true)
    			.targetUrl("https://www.icourse163.org/category/all#?type=30&orderBy=0&pageIndex=1")
    			.needToDownloadImg(true)
    			.imgPath("D://photos//.imooc")
    			.needToStoreDataToExcel(true)
    			.excelStorePath("//D:\\111")
    			.excelFileName("课程")
    			.build();
    	crawler.crawCourseDtos();
    }
}
