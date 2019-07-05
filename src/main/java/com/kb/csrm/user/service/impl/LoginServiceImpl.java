/**
 * The type LoginServiceImpl.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.user.service.impl;

import com.kb.csrm.user.dto.UserDto;
import com.kb.csrm.user.mapper.UserMapper;
import com.kb.csrm.user.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto login(String account) {

        int acc = Integer.parseInt(account);
        return userMapper.login(acc);
    }
}