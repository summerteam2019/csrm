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
    public List<CourseDto> getAllCourse(){
        System.out.println(courseMapper.getAllCourse());
        return courseMapper.getAllCourse();
    }

    @Override
    public void insertCourse(CourseDto courseDto) {
        courseMapper.insertCourse(courseDto);
    }

    @Override
    public CourseDto selectCourseById(int courseId) {
        return courseMapper.selectCourseById(courseId);
    }

    @Override
    public void deleteCourseById(int courseId) {
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(courseId);
        courseMapper.deleteCourseById(courseDto);
    }

    @Override
    public void updateCourseById(CourseDto courseDto) {
        courseMapper.updateCourseById(courseDto);
    }


    @Override
    public List<CourseDto> getCourseByKeyWord(String courseName){
        return courseMapper.getCourseByKeyWord(courseName);
    }

    @Override
    public String getCollegeName(CourseDto courseDto){
        return courseMapper.getCollegeName(courseDto);
    }
}
