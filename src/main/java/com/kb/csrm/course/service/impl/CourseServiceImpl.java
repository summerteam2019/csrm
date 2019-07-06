package com.kb.csrm.course.service.impl;

import com.kb.csrm.course.dto.CourseDto;
import com.kb.csrm.course.mapper.CourseMapper;
import com.kb.csrm.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements ICourseService{
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public boolean validCourse(Map<String,Object> map) {
        boolean flag=true;
        List<CourseDto>list=courseMapper.getCourseByCon(map);
        int x=(Integer)map.get("id");
        if(x!=0){//修改
            if((list.size()==1&&x==list.get(0).getCourseId())){
                flag=true;
            }else if(list.size()==0){
                flag=true;
            }else{
                flag=false;
            }
        }else{//添加
            if(list.size()>0){
                flag=false;
            }
        }
        return flag;
    }

    @Override
    public void insertCourse(CourseDto courseDto) {
        courseMapper.insertCourse(courseDto);
    }

    @Override
    public CourseDto selectCourseById(Long courseId) {
        return courseMapper.selectCourseById(courseId);
    }

    @Override
    public CourseDto deleteCourseById(Long courseId) {
        return courseMapper.deleteCourseById(courseId);
    }

    @Override
    public CourseDto updateCourseById(Long courseId) {
        return courseMapper.updateCourseById(courseId);
    }
}
