/**
 * The type Usermapper.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.user.mapper;

import com.kb.csrm.user.dto.UserDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
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
}
