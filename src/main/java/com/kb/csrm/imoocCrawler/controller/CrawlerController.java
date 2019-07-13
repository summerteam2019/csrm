/**
 * 爬虫控制器
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/07/08
 */

package com.kb.csrm.imoocCrawler.controller;

import com.kb.csrm.imoocCrawler.crawler.Crawler;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/craw")
public class CrawlerController {

    @Autowired
    private Crawler crawler;

    /**
     * 开始爬取
     * @return
     */
    @RequestMapping("/do")
    public boolean craw () {

        crawler.crawCourseDtos();
        return true;
    }
}
