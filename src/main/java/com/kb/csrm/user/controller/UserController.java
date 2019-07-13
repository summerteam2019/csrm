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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 忘记密码
     * @param account
     * @return
     */
    @RequestMapping("/forgetPassword")
    @ResponseBody
    public HashMap forgetPassword(long account){
        HashMap map = new HashMap<String,Object>(16);
        String pwquestion = userService.getPwQuestion(account);
        if (null != pwquestion && ""!=pwquestion) {
            map.put("flag",1);
            map.put("pwquestion",userService.getPwQuestion(account));
        } else {
            map.put("flag",0);
        }
        return map;
    }

    /**
     * 修改密码
     * @param account
     * @param password
     */
    @RequestMapping("/changePassword")
    @ResponseBody
    public Map changePassword(@RequestParam("account") long account, @RequestParam("newPassword") String password, @RequestParam("pwQuestion") String pwQuestion, @RequestParam("pwAnswer") String pwAnswer) {
        int flag = userService.confirmPwAnswer(account,pwQuestion,pwAnswer);
        HashMap map = new HashMap<String,Object>(16);
        if (flag > 0) {
            userService.changePassword(account,password);
            map.put("flag",1);
            return map;
        } else {
            map.put("flag",0);
            return map;
        }
    }

    /**
     * 修改密码2
     * @param oldPassword
     * @param password
     */
    @RequestMapping("/changePassword2")
    @ResponseBody
    public Map changePassword2(@RequestParam("newPassword") String password, @RequestParam("oldPassword") String oldPassword, HttpServletRequest request) {
        long account = (long) request.getSession().getAttribute("ACCOUNT");
        int flag = userService.confirmPassword(account,oldPassword);
        HashMap map = new HashMap<String,Object>(16);
        if (flag > 0) {
            userService.changePassword(account,password);
            map.put("flag",1);
            return map;
        } else {
            map.put("flag",0);
            return map;
        }
    }

    /**
     * 获取session信息
     * @param request
     * @return
     */
    @RequestMapping("/getSession")
    @ResponseBody
    public Map getSession(HttpServletRequest request) {
        long account = (long) request.getSession().getAttribute("ACCOUNT");
        String name = (String) request.getSession().getAttribute("NAME");
        int id = (int) request.getSession().getAttribute("ID");
        String role = (String) request.getSession().getAttribute("ROLE");
        String school = (String) request.getSession().getAttribute("SCHOOL");
        String faculty = (String) request.getSession().getAttribute("FACULTY");
        int age = (int) request.getSession().getAttribute("AGE");
        String education = (String) request.getSession().getAttribute("EDUCATION");
        String mail = (String) request.getSession().getAttribute("MAIL");
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("account", account);
        map.put("name", name);
        map.put("id", id);
        map.put("role", role);
        map.put("school", school);
        map.put("faculty", faculty);
        map.put("age", age);
        map.put("education", education);
        map.put("mail",mail);
        return map;
    }
}

