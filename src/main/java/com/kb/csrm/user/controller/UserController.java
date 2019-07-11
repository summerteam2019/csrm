/**
 * The type UserController.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/07/02
 */

package com.kb.csrm.user.controller;

import com.kb.csrm.user.dto.UserDto;
import com.kb.csrm.user.service.IUserService;
import com.kb.csrm.util.BaseController;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    /**
     * 获取全部用户列表
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(path="/getAllUser")
    @ResponseBody
    public List<UserDto> getAllUser(ModelMap modelMap){
        List<UserDto> userList = userService.getAllUser();
        modelMap.addAttribute("userList",userList);
        return userList;
    }

    /**
     * 创建新用户
     * @param userDto
     * @return
     */
    @RequestMapping("/create")
    @ResponseBody
    public boolean insertUserById(UserDto userDto){
        userService.insertUserById(userDto);
        return true;
    }

    /**
     * 根据用户名搜素
     * @param userName
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public List<UserDto> getUserByName(String userName){
        List<UserDto> userList = userService.getUserByName(userName);
        return userList;
    }

    /**
     * 获取全部用户
     * @param request
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public ResponseData queryUser (HttpServletRequest request){

        return new ResponseData(userService.query());
    }

    /**
     * 根据ID删除用户
     * @param userId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public boolean deleteUserById(@RequestParam("userId") int userId){
        userService.deleteUserById(userId);
        return true;
    }

    /**
     * 管理员修改用户信息
     * @param userDto
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Boolean updateCourseById(UserDto userDto){
        userService.updateUserById(userDto);
        return true;
    }

    /**
     * 用户修改个人信息
     * @param userDto
     * @return
     */
    @RequestMapping("/updateInfo")
    @ResponseBody
    public boolean updateInfo(UserDto userDto){
        userService.updateInfo(userDto);
        return true;
    }

    @RequestMapping("/forgetPassword")
    @ResponseBody
    public boolean forgetPassword(long account){
        int flag = userService.forgetPassword(account);
        if(flag > 0) {
            return true;
        } else {
            return false;
        }
    }

}
