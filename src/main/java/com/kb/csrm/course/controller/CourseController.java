/**
 * The type CourseController
 *
 * @author 陈开国 & 曾佳进714705217@qq.com & yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/7/11
 */

package com.kb.csrm.course.controller;

import com.kb.csrm.course.dto.CourseDto;
import com.kb.csrm.course.service.ICourseService;
import com.kb.csrm.util.BaseController;
import com.kb.csrm.util.ResponseData;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 获取所有课程
     * @return
     */
    @RequestMapping("/getAllCourse")
    @ResponseBody
    public List<CourseDto> getAllCourse(){
        return courseService.getAllCourse();
    }

    /**
     * 根据课程名获取课程
     * @param courseName
     * @return
     */
    @RequestMapping(path="/select")
    @ResponseBody
    public List<CourseDto> getCourseByName(String courseName){
        List<CourseDto> courseList = courseService.getCourseByKeyWord(courseName);
        return courseList;
    }

    /**
     * 添加课程
     * @param courseDto
     * @return
     */
    @RequestMapping("/create")
    @ResponseBody
    public boolean insertCourse(CourseDto courseDto){
        courseService.insertCourse(courseDto);
        return true;
    }

    /**
     * 根据课程ID获取课程
     * @param courseId
     * @return
     */
    @RequestMapping("/selectOne")
    @ResponseBody
    public CourseDto selectCourseById(@RequestParam("courseId") int courseId){
        return courseService.selectCourseById(courseId);
    }

    /**
     * 删除课程
     * @param courseId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public boolean deleteCourseById(@RequestParam("courseId") int courseId){
        courseService.deleteCourseById(courseId);
        return true;
    }

    /**
     * 修改课程信息
     * @param courseDto
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Boolean updateCourseById(CourseDto courseDto){
        courseService.updateCourseById(courseDto);
        return true;
    }

    /**
     * 根据关键字获取课程
     * @param courseName
     * @return
     */
    @RequestMapping("/getCourseByKeyWord")
    @ResponseBody
    public ResponseData getCourseByKeyWord(String courseName) {
        List<CourseDto> courseList = courseService.getCourseByKeyWord(courseName);
        Object[] allCourse = new Object[2];
        String[] collegeName = new String[courseList.size()];
        for(int i = 0; i < courseList.size(); i++){
            collegeName[i] = courseService.getCollegeName(courseList.get(i));
        }
        allCourse[0] = courseList;
        allCourse[1] = collegeName;
        ResponseData result = new ResponseData(courseService.getCourseByKeyWord(courseName));
        return new ResponseData(courseService.getCourseByKeyWord(courseName));
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
     * 获取已选课程
     *
     * @return
     */
    @RequestMapping("/getChosenCourse")
    @ResponseBody
    public ResponseData getChosenCourse(HttpServletRequest request){
        int userId = (int) request.getSession().getAttribute("ID");
        return new ResponseData(courseService.getChosenCourse(userId));
    }

    /**
     * 获取教授课程
     *
     * @return
     */
    @RequestMapping("/getTaughtCourse")
    @ResponseBody
    public ResponseData getTaughtCourse(HttpServletRequest request){
        int userId = (int) request.getSession().getAttribute("ID");
        return new ResponseData(courseService.getTaughtCourse(userId));
    }

    /**
     * 获取点击量最高的5门课程
     *
     * @return
     */
    @RequestMapping("/getHighCount")
    @ResponseBody
    public ResponseData getHighCount(HttpServletRequest request){
        return new ResponseData(courseService.getHighCount(5));
    }


}
