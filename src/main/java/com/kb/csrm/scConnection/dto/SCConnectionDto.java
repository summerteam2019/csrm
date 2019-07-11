/**
 * 选课模块实体类
 *
 * @author zengjiajin
 * @version 1.0
 * @date 2019/07/05
 */
package com.kb.csrm.scConnection.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="student_course_connection")
public class SCConnectionDto {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(generator = "IDENTITY")
    private Integer scConnectionId;

    /**
     * 学生ID
     */
    @Column
    private Integer userId;

    /**
     * 课程ID
     */
    @Column
    private Integer courseId;

    /**
     * 选课时间
     */
    @Column
    private String scTime;

    public Integer getScConnectionId(){
        return scConnectionId;
    }

    public void setScConnectionId(Integer scConnectionId){
        this.scConnectionId = scConnectionId;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getCourseId(){
        return courseId;
    }

    public void setCourseId(Integer courseId){
        this.courseId = courseId;
    }

    public String getScTime() {
        return scTime;
    }

    public void setScTime(String scTime) {
        this.scTime = scTime;
    }
}
