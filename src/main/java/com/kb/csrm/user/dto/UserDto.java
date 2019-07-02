/**
 * The type UserDto.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.user.dto;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user")
public class UserDto {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(generator = "IDENTITY")
    private int userId;
    /**
     * 用户名
     */
    @Column
    private String userName;
    /**
     * 账号
     */
    @Column
    private String account;
    /**
     * 密码
     */
    @Column
    private String password;
    /**
     * 角色ID
     */
    @Column
    private String roleName;
    /**
     * 邮箱
     */
    @Column
    private String mail;
    /**
     * 学校ID
     */
    @Column
    private int collegeId;
    /**
     * 院系ID
     */
    @Column
    private int facultyId;
    /**
     * 年龄
     */
    @Column
    private int age;
    /**
     * 学历
     */
    @Column
    private String education;
    /**
     * 密保问题
     */
    @Column
    private String pwQuestion;
    /**
     * 密保答案
     */
    @Column
    private String pwAnswer;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleId(String roleName) {
        this.roleName = roleName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPwQuestion() {
        return pwQuestion;
    }

    public void setPwQuestion(String pwQuestion) {
        this.pwQuestion = pwQuestion;
    }

    public String getPwAnswer() {
        return pwAnswer;
    }

    public void setPwAnswer(String pwAnswer) {
        this.pwAnswer = pwAnswer;
    }
}
