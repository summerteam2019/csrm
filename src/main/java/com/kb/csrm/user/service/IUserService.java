/**
 * The type IUserService.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.user.service;

import com.kb.csrm.user.dto.UserDto;

import java.util.List;

public interface IUserService {

    /**
     * 获取所有用户
     * @return
     */
    List<UserDto> getAllUser();

    /**
     * 添加新用户
     * @param userDto
     */
    void insertUserById (UserDto userDto);

    /**
     * 根据名称获取用户
     * @param
     * @return
     */
    List<UserDto> getUserByName(String UserName);



    /**
     * 查找所有用户
     * @return
     */
    List<UserDto> query();

    /**
     * 按ID删除用户
     * @param userId
     * @return
     */
    void deleteUserById (int userId);

    /**
     * 按ID更改用户信息
     * @param
     * @return
     */
    void updateUserById (UserDto userDto);

    /**
     * 修改个人信息
     * @param
     * @return
     */
    void updateInfo (UserDto userDto);

    /**
     * 修改密码
     * @param account
     * @param password
     */
    void changePassword(long account, String password);

    /**
     * 确认密保答案
     * @param account
     * @param pwQuestion
     * @param pwAnswer
     * @return
     */
    int confirmPwAnswer(long account, String pwQuestion, String pwAnswer);

    /**
     * 获取密保问题
     * @param account
     * @return
     */
    String getPwQuestion(long account);

    /**
     * 确认密码
     * @param account
     * @param oldPassword
     * @return
     */
    int confirmPassword(long account, String oldPassword);
}
