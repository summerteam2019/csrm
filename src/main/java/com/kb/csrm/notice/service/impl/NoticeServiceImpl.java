/**
 * The type NoticeServiceImpl.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.notice.service.impl;

import com.kb.csrm.notice.dto.NoticeDto;
import com.kb.csrm.notice.mapper.NoticeMapper;
import com.kb.csrm.notice.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public void insertNotice(NoticeDto noticeDto) {
        noticeMapper.insertNotice(noticeDto);
    }

    @Override
    public List<NoticeDto> getNoticeByCourseId(double courseId) {
        return noticeMapper.getNoticeByCourseId(courseId);
    }
}
