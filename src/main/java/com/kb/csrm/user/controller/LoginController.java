/**
 * The type LoginController.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/07/05
 */

package com.kb.csrm.user.controller;

import com.kb.csrm.user.dto.UserDto;
import com.kb.csrm.user.service.ILoginService;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    /**
     * 登陆校验
     *
     * @param name
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("/check")
    @ResponseBody
    public Map<String, Object> createUser(@RequestParam("username") long name, @RequestParam("password") String password, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<String, Object>();
        Integer flag = null;
        UserDto userDto = loginService.login(name);
        if (userDto != null) {
            if (password.equals(userDto.getPassword())) {
                flag = 0;
                //登陆成功
                map.put("id", userDto.getUserId());
                map.put("role", userDto.getRoleName());
                request.getSession().setAttribute("NAME", userDto.getUserName());
                request.getSession().setAttribute("ACCOUNT", userDto.getAccount());
                request.getSession().setAttribute("ID", userDto.getUserId());
                request.getSession().setAttribute("ROLE", userDto.getRoleName());
                request.getSession().setAttribute("SCHOOL", userDto.getCollegeName());
                request.getSession().setAttribute("FACULTY", userDto.getFacultyName());
                request.getSession().setAttribute("AGE", userDto.getAge());
                request.getSession().setAttribute("EDUCATION", userDto.getEducation());
                request.getSession().setAttribute("MAIL",userDto.getMail());
            } else {
                flag = 1;
                //登录密码不正确
            }
        } else {
            flag = 2;
            //此账号不存在
        }
        map.put("flag", flag);
        return map;
    }

    /**
     * 注册新用户
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/signup")
    @ResponseBody
    public ResponseData signUp(UserDto user, HttpServletRequest request) {
        loginService.signup(user);
        return new ResponseData(true);
    }
}
