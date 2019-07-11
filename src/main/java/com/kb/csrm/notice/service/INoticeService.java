package com.kb.csrm.notice.service;

import com.kb.csrm.notice.dto.NoticeDto;

import java.util.List;

public interface INoticeService {

    /**
     * 创建新通知
     * @param noticeDto 课程信息
     * @return
     */
    void insertNotice(NoticeDto noticeDto);

    /**
     * 获取课程通知
     * @param courseId 课程ID
     * @return
     */
    List<NoticeDto> getNoticeByCourseId(double courseId);
}
