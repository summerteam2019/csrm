package com.kb.csrm.appraise.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;

@Table(name="appraise")
public class AppraiseDto {

    @Id
    @GeneratedValue(generator = "IDENTITY")
    private int appraiseId;

    @Column
    private int userId;

    @Column
    private int courseId;

    @Column
    private int appraiseGrade;

    @Column
    private String appraiseContent;

    @Column
    private Data appraiseTime;

    @Column
    private int appraiseRaise;

    public int getAppraiseId(){
        return appraiseId;
    }

    public void setAppraiseId(int appraiseId){
        this.appraiseId = appraiseId;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getCourseId(){
        return courseId;
    }

    public void setCourseId(int courseId){
        this.courseId = courseId;
    }

    public int getAppraiseGrade(){
        return appraiseGrade;
    }

    public void setAppraiseGrade(int appraiseGrade){
        this.appraiseGrade = appraiseGrade;
    }

    public String getAppraiseContent(){
        return appraiseContent;
    }

    public void setAppraiseContent(String appraiseContent){
        this.appraiseContent = appraiseContent;
    }

    public Data getAppraiseTime(){
        return appraiseTime;
    }

    public void setAppraiseTime(Data appraiseTime){
        this.appraiseTime = appraiseTime;
    }

    public int getAppraiseRaise(){
        return appraiseRaise;
    }

    public void setAppraiseRaise(int appraiseRaise){
        this.appraiseRaise = appraiseRaise;
    }
}
