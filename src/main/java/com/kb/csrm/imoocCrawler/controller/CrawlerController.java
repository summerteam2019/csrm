/**
 * The type CrawlerController.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
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

    @RequestMapping("/do")
    public ResponseData craw () {

        crawler.crawCourseDtos();
        return new ResponseData(true);
    }
}
