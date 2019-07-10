package com.kb.csrm.course.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table (name="course")
public class CourseDto {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(generator = "IDENTITY")
    private int courseId;
    /**
     * 教师ID
     */
    @Column
    private int teacherId;
    /**
     * 院校ID
     */
    @Column
    private int collegeId ;
    /**
     * 教师姓名
     */
    @Column
    private String teacherName;
    /**
     * 课程名
     */
    @Column
    private String courseName;
    /**
     * 课程介绍
     */
    @Column
    private String courseIntroduce;
    /**
     * 课程时间
     */
    @Column
    private String courseTime;
    /**
     * 课程评分
     */
    @Column
    private int courseRate;
    /**
     * 点击次数
     */
    @Column
    private int courseCount;
    /**
     * 是否推荐
     */
    @Column
    private int recommend;
    /**
     * 课程所属大学名称
     */
    @Transient
    private String collegeName;

    /**
     * 课程所属学院名称
     */
    @Transient
    private String facultyName;

    @Transient
    private int ifChose;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseIntroduce() {
        return courseIntroduce;
    }

    public void setCourseIntroduce(String courseIntroduce) {
        this.courseIntroduce = courseIntroduce;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public int getCourseRate() {
        return courseRate;
    }

    public void setCourseRate(int courseRate) {
        this.courseRate = courseRate;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public int getIfChose() {
        return ifChose;
    }

    public void setIfChose(int ifChose) {
        this.ifChose = ifChose;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

}