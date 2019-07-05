/**
 * The type UserController.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.user.controller;

import com.kb.csrm.user.dto.UserDto;
import com.kb.csrm.user.service.IUserService;
import com.kb.csrm.util.BaseController;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/create")
    @ResponseBody
    public ResponseData createUser(@RequestBody UserDto userDto, HttpServletRequest request){

        userService.insertUser(userDto);
        return new ResponseData(true);
    }

    @RequestMapping("/selectOne")
    @ResponseBody
    public ResponseData selectUserById(@RequestBody Long userId, HttpServletRequest request){

        userService.selectUserById(userId);
        return new ResponseData(true);
    }

    @RequestMapping("/query")
    @ResponseBody
    public ResponseData queryUser (HttpServletRequest request){

        return new ResponseData(userService.query());
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData deleteUserById(@RequestBody Long userId, HttpServletRequest request){

        userService.deleteUserById(userId);
        return new ResponseData(true);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updateUserById(@RequestBody Long userId, HttpServletRequest request){

        userService.updateUserById(userId);
        return new ResponseData(true);
    }

}
