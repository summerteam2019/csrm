package com.kb.csrm.college.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="college")
public class CollegeDto {

    @Id
    @GeneratedValue(generator = "IDENTITY")
    private int collegeId;

    @Column
    private String collegeName;

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
