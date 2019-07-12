package com.kb.csrm.user.service;

import com.kb.csrm.user.dto.UserDto;

public interface ILoginService {

    /**
     * 登陆校验
     * @param account
     */
    UserDto login(long account);

    /**
     * 注册
     * @param user
     */
    void signup(UserDto user);

    /**
     * 获取包含院校的session
     * @param name
     * @return
     */
    UserDto loginSession(long name);
}
