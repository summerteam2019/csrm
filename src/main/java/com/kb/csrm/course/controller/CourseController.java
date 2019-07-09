package com.kb.csrm.course.controller;

import com.kb.csrm.course.dto.CourseDto;
import com.kb.csrm.course.service.ICourseService;
import com.kb.csrm.util.BaseController;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController extends BaseController{

    @Autowired
    private ICourseService courseService;

    @RequestMapping("/getAllCourse")
    @ResponseBody
    public List<CourseDto> getAllCourse(){
        return courseService.getAllCourse();
    }


    /**添加课程*/
    @RequestMapping("/create")
    @ResponseBody
    public boolean insertCourse(CourseDto courseDto){
        courseService.insertCourse(courseDto);
        return true;
    }

    /**查询课程*/
    @RequestMapping("/select")
    @ResponseBody
    public CourseDto selectCourseByIdById(CourseDto courseDto){
        int courseId = courseDto.getCourseId();
        return courseService.selectCourseById(courseId);
    }


    /**删除课程*/
    @RequestMapping("/delete")
    @ResponseBody
    public boolean deleteCourseById(@RequestBody int courseId){
        courseService.deleteCourseById(courseId);
        return true;
    }

    /**修改课程信息*/
    @RequestMapping("/update")
    @ResponseBody
    public Boolean updateCourseById(CourseDto courseDto){
        courseService.updateCourseById(courseDto);
        return true;
    }

    @RequestMapping("/getCourseByKeyWord")
    @ResponseBody
    public Object[] getCourseByKeyWord(String courseName) {
        List<CourseDto> courseList = courseService.getCourseByKeyWord(courseName);
        Object[] allCourse = new Object[2];
        String[] collegeName = new String[courseList.size()];
        for(int i = 0; i < courseList.size(); i++){
            collegeName[i] = courseService.getCollegeName(courseList.get(i));
        }
        allCourse[0] = courseList;
        allCourse[1] = collegeName;
        return allCourse;
    }

    /**
     * 获取推荐课程
     *
     * @return
     */
    @RequestMapping("/getRecommend")
    @ResponseBody
    public ResponseData getRecommendedCourse(HttpServletRequest request){
        return new ResponseData(courseService.getRecommendedCourse());
    }

    /**
     * 获取推荐课程
     *
     * @return
     */
    @RequestMapping("/getChosenCourse")
    @ResponseBody
    public ResponseData getChosenCourse(@RequestParam("userId") Long userId, HttpServletRequest request){
        return new ResponseData(courseService.getChosenCourse(userId));
    }

}
