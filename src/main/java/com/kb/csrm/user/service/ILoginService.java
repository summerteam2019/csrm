package com.kb.csrm.user.service;

import com.kb.csrm.user.dto.UserDto;

public interface ILoginService {

    /**
     * 登陆校验
     * @param account
     */
    UserDto login(String account);
}
