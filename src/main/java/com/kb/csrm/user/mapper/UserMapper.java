/**
 * The type Usermapper.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/07/04
 */

package com.kb.csrm.user.mapper;

import com.kb.csrm.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 获取所有院校
     *
     * @return
     */
    List<UserDto> getAllUser();

    /**
     * 根据用户名称获取用户信息
     *
     * @param
     * @return
     */
    List<UserDto> getUserByName(String userName);

    /**
     * 添加新用户
     *
     * @param userDto
     */
    void insertUser(UserDto userDto);


    /**
     * 根据筛选条件查询用户
     *
     * @return
     */
    List<UserDto> query();

    /**
     * 根据ID删除用户
     *
     * @param
     * @return
     */
    void deleteUserById(UserDto userDto);

    /**
     * 根据ID更改用户
     *
     * @param
     * @return
     */
    void updateUserById(UserDto userDto);

    /**
     * 登陆校验
     *
     * @param account
     * @return
     */
    UserDto login(@Param(value = "account") int account);

    /**
     * 注册
     *
     * @param user
     */
    void signup(UserDto user);

    /**
     * 修改用户信息
     *
     * @param userDto
     */
    void updateInfo(UserDto userDto);

    /**
     * 修改密码
     * @param account
     * @param password
     * @return
     */
    void changePassword(@Param("account") long account, @Param("password") String password);

    /**
     * 获取密保问题
     * @param account
     * @return
     */
    String getPwQuestion(long account);

    /**
     * 确认密保答案
     * @param account
     * @param pwQuestion
     * @param pwAnswer
     * @return
     */
    int confirmPwAnswer(@Param("account") long account,@Param("pwQuestion") String pwQuestion,@Param("pwAnswer") String pwAnswer);

    /**
     * 确认密码
     * @param account
     * @param oldPassword
     * @return
     */
    int confirmPassword(@Param("account") long account,@Param("password")  String oldPassword);
}



