/**
 * The type AppraiseController
 *
 * @author 曾佳进 714705217@qq.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

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

    /**
     * 获取所有评论
     * @param modelMap
     * @return
     */
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

    /**
     * 通过ID获取评论
     * @param appraiseDto
     * @return
     */
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

    /**
     * 通过用户ID获取评论
     * @param userId
     * @param request
     * @return
     */
    @RequestMapping("/getAppraiseByUserId")
    @ResponseBody
    public ResponseData getAppraiseByUserId(@RequestBody int userId, HttpServletRequest request){
        appraiseService.getAppraiseByUserId(userId);
        return new ResponseData(true);
    }

    /**
     * 通过课程ID获取评论
     * @param courseId
     * @return
     */
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

    /**
     * 通过用户和课程ID获取评论
     * @param userId
     * @param courseId
     * @return
     */
    @RequestMapping("/getAppraiseByUserAndCourse")
    @ResponseBody
    public AppraiseDto getAppraiseByUserAndCourse(int userId, int courseId){
        return appraiseService.getAppraiseByUserAndCourse(userId, courseId);
    }

    /**
     * 通过关键字获取评论
     * @param appraiseDto
     * @return
     */
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

    /**
     * 发表评论
     * @param appraiseDto
     * @return
     */
    @RequestMapping("/addAppraise")
    @ResponseBody
    public boolean addAppraise(AppraiseDto appraiseDto){
        appraiseService.addAppraise(appraiseDto);
        return true;
    }

    /**
     * 删除评论
     * @param appraiseId
     * @return
     */
    @RequestMapping("/deleteAppraise")
    @ResponseBody
    public boolean deleteAppraise(int appraiseId){

        appraiseService.deleteAppraise(appraiseId);
        return true;
    }

    /**
     * 修改评论
     * @param appraiseDto
     * @return
     */
    @RequestMapping("/updateAppraise")
    @ResponseBody
    public boolean updateAppraise(AppraiseDto appraiseDto){
        appraiseService.updateAppraise(appraiseDto);
        return true;
    }
}
