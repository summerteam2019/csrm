package com.kb.csrm.scConnection.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="student_course_connection")
public class SCConnectionDto {

    @Id
    @GeneratedValue(generator = "IDENTITY")
    private Integer scConnectionId;

    @Column
    private Integer userId;

    @Column
    private Integer courseId;

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
}
