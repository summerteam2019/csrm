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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping(path="/getAllUser")
    @ResponseBody
    public List<UserDto> getAllUser(ModelMap modelMap){
        List<UserDto> userList = userService.getAllUser();
        modelMap.addAttribute("userList",userList);
        return userList;
    }

    @RequestMapping("/create")
    @ResponseBody
    public boolean insertUserById(UserDto userDto){
        userService.insertUserById(userDto);
        return true;
    }


    @RequestMapping("/select")
    @ResponseBody
    public List<UserDto> getUserByName(String userName){
        List<UserDto> userList = userService.getUserByName(userName);
        return userList;
    }

    @RequestMapping("/query")
    @ResponseBody
    public ResponseData queryUser (HttpServletRequest request){

        return new ResponseData(userService.query());
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean deleteUserById(@RequestParam("userId") int userId){
        userService.deleteUserById(userId);
        return true;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Boolean updateCourseById(UserDto userDto){
        userService.updateUserById(userDto);
        return true;
    }

    @RequestMapping("/updateInfo")
    @ResponseBody
    public boolean updateInfo(UserDto userDto){
        userService.updateInfo(userDto);
        return true;
    }

}
