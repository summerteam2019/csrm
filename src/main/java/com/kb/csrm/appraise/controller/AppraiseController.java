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
    public Object[] getAllAppraise(ModelMap modelMap){
        List<AppraiseDto> appraiseList = appraiseService.getAllAppraise();
        Object[] allAppraise = new Object[3];
        String[] userName = new String[appraiseList.size()];
        String[] courseName = new String[appraiseList.size()];
        allAppraise[0] = appraiseList;
        allAppraise[1] = userName;
        allAppraise[2] = courseName;
        for(int i = 0; i < appraiseList.size(); i++){
           userName[i] = appraiseService.getAppraiseUser(appraiseList.get(i));
           courseName[i] = appraiseService.getAppraiseCourse(appraiseList.get(i));
        }
        modelMap.addAttribute("appraiseList",appraiseList);
        return allAppraise;
    }

    @RequestMapping("/getAppraiseById")
    @ResponseBody
    public Object[] getAppraiseById(AppraiseDto appraiseDto){
        int appraiseId = appraiseDto.getAppraiseId();
        appraiseDto = appraiseService.getAppraiseById(appraiseId);
        String userName = appraiseService.getAppraiseUser(appraiseDto);
        String courseName = appraiseService.getAppraiseCourse(appraiseDto);
        Object[] appraiseObject = new Object[3];
        appraiseObject[0] = (AppraiseDto)appraiseDto;
        appraiseObject[1] = (String)userName;
        appraiseObject[2] = (String)courseName;
        return appraiseObject;
    }

    @RequestMapping("/getAppraiseByUserId")
    @ResponseBody
    public ResponseData getAppraiseByUserId(@RequestBody int userId, HttpServletRequest request){
        appraiseService.getAppraiseByUserId(userId);
        return new ResponseData(true);
    }

    @RequestMapping("/getAppraiseByCourseId")
    @ResponseBody
    public Object[] getAppraiseByCourseId(int courseId){
        Object[] appraiseCourse = new Object[2];
        List<AppraiseDto> appraiseList = appraiseService.getAppraiseByCourseId(courseId);
        String[] userName = new String[appraiseList.size()];
        for(int i = 0; i < appraiseList.size(); i++){
            userName[i] = appraiseService.getAppraiseUser(appraiseList.get(i));
        }
        appraiseCourse[0] = appraiseList;
        appraiseCourse[1] = userName;
        return appraiseCourse;
    }

    @RequestMapping("/getAppraiseByUserAndCourse")
    @ResponseBody
    public AppraiseDto getAppraiseByUserAndCourse(int userId, int courseId){
        return appraiseService.getAppraiseByUserAndCourse(userId, courseId);
    }

    @RequestMapping("/getAppraiseByKeyWord")
    @ResponseBody
    public Object[] getAppraiseByKeyWord(AppraiseDto appraiseDto){
        String keyWord = appraiseDto.getAppraiseContent();
        List<AppraiseDto> appraiseList = appraiseService.getAppraiseByKeyWord(keyWord);
        Object[] allAppraise = new Object[3];
        String[] kuserName = new String[appraiseList.size()];
        String[] kcourseName = new String[appraiseList.size()];
        for(int i = 0; i < appraiseList.size(); i++){
            kuserName[i] = appraiseService.getAppraiseUser(appraiseList.get(i));
            kcourseName[i] = appraiseService.getAppraiseCourse(appraiseList.get(i));
        }
        allAppraise[0] = appraiseList;
        allAppraise[1] = kuserName;
        allAppraise[2] = kcourseName;
        return allAppraise;
    }

    @RequestMapping("/addAppraise")
    @ResponseBody
    public boolean addAppraise(AppraiseDto appraiseDto){

        appraiseService.addAppraise(appraiseDto);
        return true;
    }

    @RequestMapping("/deleteAppraise")
    @ResponseBody
    public boolean deleteAppraise(int appraiseId){

        appraiseService.deleteAppraise(appraiseId);
        return true;
    }

    @RequestMapping("/updateAppraise")
    @ResponseBody
    public boolean updateAppraise(AppraiseDto appraiseDto){
        appraiseService.updateAppraise(appraiseDto);
        return true;
    }
}
