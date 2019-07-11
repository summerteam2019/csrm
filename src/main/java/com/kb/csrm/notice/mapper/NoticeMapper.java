/**
 * The type NoticeMapper.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/07/10
 */

package com.kb.csrm.notice.mapper;

import com.kb.csrm.notice.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {

    /**
     * 获取课程通知
     * @param courseId
     * @return
     */
    List<NoticeDto> getNoticeByCourseId(@Param("courseId") double courseId);

    /**
     * 新增课程通知
     * @param noticeDto
     */
    void insertNotice (NoticeDto noticeDto);
}
