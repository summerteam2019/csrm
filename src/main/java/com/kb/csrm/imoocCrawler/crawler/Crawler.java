package com.kb.csrm.imoocCrawler.crawler;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

import com.kb.csrm.course.dto.CourseDto;
import com.kb.csrm.course.mapper.CourseMapper;
import lombok.extern.slf4j.Slf4j;


import com.kb.csrm.imoocCrawler.factory.ThreadFactory;
import com.kb.csrm.imoocCrawler.util.DownloadUtil;
import com.kb.csrm.imoocCrawler.util.HtmlParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Crawler
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/07/08
 */
@Slf4j
@Service
public class Crawler {

    @Autowired
    private CourseMapper courseMapper;

    private final static Logger log = LoggerFactory.getLogger(Crawler.class);

    private boolean needToDownloadImg = true;
    private boolean print = true;
    private String imgPath = System.getProperty("user.home") + "/Documents/csrm/src/main/resources/static/img/course";
    private String targetUrl = "http://www.imooc.com/course/list?page=1";
    private ThreadPoolExecutor threadPool = ThreadFactory.getThreadPool();

    /**
     * 爬取url的信息
     *
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public void crawCourseDtos() {
        Map<String, Object> resultMap = HtmlParser.getInstance(targetUrl).parse(); //获取解析结果
        if (Objects.isNull(resultMap) || resultMap.isEmpty()) {
            log.info("没有获取到数据");
            return;
        }
        Map<String, String> courseImgUrlMap = (Map<String, String>) resultMap.get("imgUrlMap");
        List<CourseDto> courseList = (List<CourseDto>) resultMap.get("courseList");
        //如果需要打印课程信息，则打印课程信息，默认打印
        if (print) {
            printCourseInfo(courseList);
            courseMapper.batchInsert(courseList);
        }
        //如果需要下载图片则启动新线程进行下载
        if (needToDownloadImg) {
            downloadImgs(courseImgUrlMap);
        }
        threadPool.shutdown();
    }

    /**
     * 打印课程信息
     *
     * @param courseList 课程列表
     */
    private void printCourseInfo(List<CourseDto> courseList) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                courseList.forEach((course) -> log.info(course.toString()));
            }
        });
    }

    /**
     * 下载图片
     *
     * @param imgUrlMap 图片url集合
     */
    private void downloadImgs(Map<String, String> imgUrlMap) {
        if (null == imgPath) {
            imgPath = "";
        }
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                if (Objects.isNull(imgUrlMap) || imgUrlMap.isEmpty()) {
                    log.info("没有可以下载的数据");
                    return;
                }
                log.info("开始下载");
                DownloadUtil downloadUtil = DownloadUtil.getInstance(imgPath);
                imgUrlMap.forEach((courseName, imgURL) -> {
                    downloadUtil.downloadCourseImg(courseName, imgURL);
                });
                log.info("下载完成");
            }
        });
    }

}
