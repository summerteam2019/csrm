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
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
public interface UserMapper {

    /**
     * 添加新用户
     * @param user
     */
    void insertUser(UserDto user);

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    UserDto selectUserById(@Param(value = "userID") double userId);

    /**
     * 根据筛选条件查询用户
     * @return
     */
    List<UserDto> query();

    /**
     * 根据ID删除用户
     * @param userId
     * @return
     */
    UserDto deleteUserById(@Param(value = "userID") double userId);

    /**
     * 根据ID更改用户
     * @param userId
     * @return
     */
    UserDto updateUserById(@Param(value = "userID") double userId);
}
