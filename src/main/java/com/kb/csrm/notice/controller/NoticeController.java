/**
 * The type NoticeControlller.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/07/10
 */

package com.kb.csrm.notice.controller;

import com.kb.csrm.notice.dto.NoticeDto;
import com.kb.csrm.notice.service.INoticeService;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    /**
     * 获取课程通知
     *
     * @param courseId
     * @return
     */
    @RequestMapping("/getNoticeByCourseId")
    public ResponseData getNoticeByCourseId(@RequestParam("courseId") double courseId) {
        return new ResponseData(noticeService.getNoticeByCourseId(courseId));
    }

    /**
     * 创建新通知
     *
     * @param noticeDto
     * @return
     */
    @RequestMapping("/insertNotice")
    public ResponseData insertNotice(NoticeDto noticeDto) {
        noticeService.insertNotice(noticeDto);
        return new ResponseData(true);
    }
}
