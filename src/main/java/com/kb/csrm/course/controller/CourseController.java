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

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController{

    @Autowired
    private ICourseService courseService;

    /**验证课程ID是否已存在*/
    @ResponseBody
    @RequestMapping("/valid.action")
    public Map<String,Object> validCourse(
            @RequestParam("name")String name,
            @RequestParam(value="id",defaultValue="0",required=false)Integer id){
        Map<String,Object>map=new HashMap<String,Object>();
        map.put("name", name);
        map.put("id", id);
        boolean flag=courseService.validCourse(map);
        Map<String,Object>maps=new HashMap<String,Object>();
        if(flag){
            maps.put("i", 1);
            maps.put("msg", "此课程ID未使用！");
        }else{
            maps.put("i", 0);
            maps.put("msg", "此课程ID已使用！");
        }
        return maps;
    }

    /**添加课程*/
    @PostMapping("/create")
    @ResponseBody
    public ResponseData insertCourse(@RequestBody CourseDto courseDto,HttpServletRequest request){
        courseService.insertCourse(courseDto);
        return new ResponseData(true);
    }

    /**查询课程*/
    @RequestMapping("/selectOne")
    @ResponseBody
    public ResponseData selectCourseById(@RequestBody Long courseId, HttpServletRequest request){

        courseService.selectCourseById(courseId);
        return new ResponseData(true);
    }

    /**删除课程*/
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData deleteCourseById(@RequestBody Long courseId, HttpServletRequest request){

        courseService.deleteCourseById(courseId);
        return new ResponseData(true);
    }

    /**修改课程信息*/
    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updateCourseById(@RequestBody Long courseId, HttpServletRequest request){

        courseService.updateCourseById(courseId);
        return new ResponseData(true);
    }

}
