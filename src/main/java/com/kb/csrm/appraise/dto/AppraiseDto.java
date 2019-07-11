/**
 * The type AppraiseDto
 *
 * @author 曾佳进 714705217@qq.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.appraise.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name="appraise")
public class AppraiseDto {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(generator = "IDENTITY")
    private int appraiseId;

    /**
     * 发表评论的用户ID
     */
    @Column
    private int userId;

    /**
     * 评论对应的课程ID
     */
    @Column
    private int courseId;

    /**
     * 评分
     */
    @Column
    private int appraiseGrade;

    /**
     * 评论内容
     */
    @Column
    private String appraiseContent;

    /**
     * 评论时间
     */
    @Column
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp appraiseTime;

    /**
     * 点赞数
     */
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

    public Timestamp getAppraiseTime(){
        return appraiseTime;
    }

    public void setAppraiseTime(Timestamp appraiseTime){
        this.appraiseTime = appraiseTime;
    }

    public int getAppraiseRaise(){
        return appraiseRaise;
    }

    public void setAppraiseRaise(int appraiseRaise){
        this.appraiseRaise = appraiseRaise;
    }
}