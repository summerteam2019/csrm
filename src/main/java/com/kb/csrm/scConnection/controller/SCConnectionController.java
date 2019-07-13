/**
 * 选课模块控制类
 *
 * @author zengjiajin
 * @version 1.0
 * @date 2019/07/05
 */
package com.kb.csrm.scConnection.controller;

import com.kb.csrm.scConnection.dto.SCConnectionDto;
import com.kb.csrm.scConnection.service.ISCConnectionService;
import com.kb.csrm.util.BaseController;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/scConnection")
public class SCConnectionController extends BaseController {

    @Autowired
    private ISCConnectionService scConnectionService;

    /**
     * 获取学生所有选课
     *
     * @param userId
     * @param request
     * @return
     */
    @RequestMapping("/getConnByUserId")
    @ResponseBody
    public ResponseData getConnByUserId(@ RequestParam("userId") Integer userId, HttpServletRequest request){

        return new ResponseData(scConnectionService.getSCConnectionByUserId(userId));
    }

    /**
     * 选课
     * @param scConnectionDto
     * @param scConnectionDto
     * @return
     */
    @RequestMapping("/addSCConnection")
    @ResponseBody
    public ResponseData addSCConnection(SCConnectionDto scConnectionDto){

        scConnectionService.addSCConnection(scConnectionDto);
        return new ResponseData(true);
    }

    /**
     * 撤课
     * @param scConnectionDto
     * @param request
     * @return
     */
    @RequestMapping("/deleteSCConnection")
    @ResponseBody
    public ResponseData deleteSCConnection(SCConnectionDto scConnectionDto, HttpServletRequest request){

        scConnectionService.deleteSCConnection(scConnectionDto);
        return new ResponseData(true);
    }

    /**
     * 判断该课程是否已选
     * @param userId
     * @param courseId
     * @param request
     * @return
     */
    @RequestMapping("/ifChoose")
    @ResponseBody
    public boolean ifChoose(@RequestParam("userId") long userId, @RequestParam("courseId") long courseId, HttpServletRequest request){

        boolean flag = scConnectionService.ifChoose(userId, courseId)==0 ? false : true;
        return flag;
    }
}
