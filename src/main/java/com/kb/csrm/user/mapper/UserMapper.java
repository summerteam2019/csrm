/**
 * The type Usermapper.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.user.mapper;

import com.kb.csrm.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
public interface UserMapper {

    /**
     * 获取所有院校
     * @return
     */
    List<UserDto> getAllUser();

    /**
     * 根据用户名称获取用户信息
     * @param
     * @return
     */
    List<UserDto> getUserByName(String userName);

    /**
     * 添加新用户
     * @param user
     */
    void insertUser(UserDto userDto);


    /**
     * 根据筛选条件查询用户
     * @return
     */
    List<UserDto> query();

    /**
     * 根据ID删除用户
     * @param
     * @return
     */
    void deleteUserById(UserDto userDto);

    /**
     * 根据ID更改用户
     * @param
     * @return
     */
    void updateUserById(UserDto userDto);

    /**
     * 登陆校验
     * @param account
     * @return
     */
    UserDto login(@Param(value="account")int account);

    /**
     * 注册
     * @param user
     */
    void signup(UserDto user);

    /**
     * 修改用户信息
     * @param userDto
     */
    void updateInfo(UserDto userDto);
}


