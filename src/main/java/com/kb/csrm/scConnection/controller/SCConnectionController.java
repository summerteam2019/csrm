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

    @RequestMapping("/getConnByUserId")
    @ResponseBody
    public ResponseData getConnByUserId(@ RequestParam("userId") Integer userId, HttpServletRequest request){

        return new ResponseData(scConnectionService.getSCConnectionByUserId(userId));
    }

    @RequestMapping("/getConnByCourseId")
    @ResponseBody
    public ResponseData getConnByCourseId(@RequestBody Integer courseId, HttpServletRequest request){

        return new ResponseData(scConnectionService.getSCConnectionByCourseId(courseId));
    }

    @RequestMapping("/addSCConnection")
    @ResponseBody
    public ResponseData addSCConnection(@RequestBody SCConnectionDto scConnectionDto, HttpServletRequest request){

        scConnectionService.addSCConnection(scConnectionDto);
        return new ResponseData(true);
    }

    @RequestMapping("/deleteSCConnection")
    @ResponseBody
    public ResponseData deleteSCConnection(@RequestBody SCConnectionDto scConnectionDto, HttpServletRequest request){

        scConnectionService.deleteSCConnection(scConnectionDto);
        return new ResponseData(true);
    }

    @RequestMapping("/ifChoose")
    @ResponseBody
    public boolean ifChoose(@RequestParam("userId") long userId, @RequestParam("courseId") long courseId, HttpServletRequest request){

        boolean flag = scConnectionService.ifChoose(userId, courseId)==0 ? false : true;
        return flag;
    }
}
