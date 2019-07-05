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
     * 添加新用户
     * @param userDto
     */
    void insertUser (UserDto userDto);

    /**
     * 按ID查找用户
     * @param userId
     * @return
     */
    UserDto selectUserById (Long userId);

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
    UserDto deleteUserById (Long userId);

    /**
     * 按ID更改用户信息
     * @param userId
     * @return
     */
    UserDto updateUserById (Long userId);
}
