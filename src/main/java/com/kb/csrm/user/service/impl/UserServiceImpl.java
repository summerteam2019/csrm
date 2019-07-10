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

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> getAllUser(){
        System.out.println(userMapper.getAllUser());
        return userMapper.getAllUser();
    }

    @Override
    public void insertUserById(UserDto userDto) {
        userMapper.insertUser(userDto);
    }

    @Override
    public List<UserDto> getUserByName(String userName){
        return userMapper.getUserByName(userName);
    }


    @Override
    public List<UserDto> query() {
        return userMapper.query();
    }

    @Override
    public void deleteUserById(int userId) {
        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userMapper.deleteUserById(userDto);
    }

    @Override
    public void updateUserById(UserDto userDto) {
        userMapper.updateUserById(userDto);
    }
}
