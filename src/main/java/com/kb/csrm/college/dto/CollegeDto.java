/**
 * The type CollegeController
 *
 * @author 曾佳进 714705217@qq.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.college.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="college")
public class CollegeDto {

    /**
     * 学校ID
     */
    @Id
    @GeneratedValue(generator = "IDENTITY")
    private int collegeId;

    /**
     * 学校名
     */
    @Column
    private String collegeName;

    /**
     * 学院名
     */
    @Column
    private String facultyName;

    public int getCollegeId(){
        return collegeId;
    }
    public void setCollegeId(int collegeId){
        this.collegeId = collegeId;
    }

    public String getCollegeName(){
        return collegeName;
    }
    public void setCollegeName(String collegeName){
        this.collegeName = collegeName;
    }

    public String getFacultyName(){
        return facultyName;
    }
    public void setFacultyName(String facultyName){
        this.facultyName = facultyName;
    }

}
