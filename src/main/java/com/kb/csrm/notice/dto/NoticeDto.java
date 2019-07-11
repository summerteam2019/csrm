/**
 * The type NoticeDto.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.notice.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "notice")
public class NoticeDto {

    @Id
    @GeneratedValue(generator = "IDENTITY")
    private double noticeId;

    /**
     * 课程ID
     */
    @Column
    private double courseId;

    /**
     * 通知内容
     */
    @Column
    private String noticeContent;

    /**
     * 发布时间
     */
    @Column
    private String noticeTime;

    public double getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(double noticeId) {
        this.noticeId = noticeId;
    }

    public double getCourseId() {
        return courseId;
    }

    public void setCourseId(double courseId) {
        this.courseId = courseId;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }
}
