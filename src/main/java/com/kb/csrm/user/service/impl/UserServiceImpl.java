/**
 * The type UserServiceImpl.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.user.service.impl;

import com.kb.csrm.user.dto.UserDto;
import com.kb.csrm.user.mapper.UserMapper;
import com.kb.csrm.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(UserDto userDto) {
        userMapper.insertUser(userDto);
    }

    @Override
    public UserDto selectUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }
}
