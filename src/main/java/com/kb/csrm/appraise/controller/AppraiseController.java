package com.kb.csrm.appraise.controller;

import com.kb.csrm.appraise.dto.AppraiseDto;
import com.kb.csrm.appraise.service.IAppraiseService;
import com.kb.csrm.util.BaseController;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/appraise")
public class AppraiseController extends BaseController {

    @Autowired
    private IAppraiseService appraiseService;

    @RequestMapping("/getAllAppraise")
    @ResponseBody
    public List<AppraiseDto> getAllAppraise(ModelMap modelMap){
        List<AppraiseDto> appraiseList = appraiseService.getAllAppraise();
        modelMap.addAttribute("appraiseList",appraiseList);
        return appraiseList;
    }

    @RequestMapping("/getAppraiseById")
    @ResponseBody
    public AppraiseDto getAppraiseById(@RequestBody int appraiseId){
        appraiseService.getAppraiseById(appraiseId);
        return appraiseService.getAppraiseById(appraiseId);
    }

    @RequestMapping("/getAppraiseByUserId")
    @ResponseBody
    public ResponseData getAppraiseByUserId(@RequestBody Integer userId, HttpServletRequest request){
        appraiseService.getAppraiseByUserId(userId);
        return new ResponseData(true);
    }

    @RequestMapping("/getAppraiseByCourseId")
    @ResponseBody
    public ResponseData getAppraiseByCourseId(@RequestBody Integer courseId, HttpServletRequest request){
        appraiseService.getAppraiseByCourseId(courseId);
        return new ResponseData(true);
    }

    @RequestMapping("/addAppraise")
    @ResponseBody
    public ResponseData addAppraise(@RequestBody AppraiseDto appraiseDto, HttpServletRequest request){

        appraiseService.addAppraise(appraiseDto);
        return new ResponseData(true);
    }

    @RequestMapping("/deleteAppraise")
    @ResponseBody
    public boolean deleteAppraise(int appraiseId){

        appraiseService.deleteAppraise(appraiseId);
        return true;
    }

    @RequestMapping("/updateAppraise")
    @ResponseBody
    public ResponseData updateAppraise(@RequestBody AppraiseDto appraiseDto, HttpServletRequest request){
        appraiseService.updateAppraise(appraiseDto);
        return new ResponseData(true);
    }
}
