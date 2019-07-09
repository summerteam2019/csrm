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
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseDto> getAllCourse() {
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
        courseMapper.deleteCourseById(courseId);
    }

    @Override
    public void updateCourseById(Long courseId) {
        courseMapper.updateCourseById(courseId);
    }

    @Override
    public List<CourseDto> getRecommendedCourse() {
        return courseMapper.getRecommend();
    }

    @Override
    public void updateCourseById(CourseDto courseDto) {
        int courseId = courseDto.getCourseId();
        courseMapper.updateCourseById(courseId);
    }


    @Override
    public List<CourseDto> getCourseByKeyWord(String courseName) {
        return courseMapper.getCourseByKeyWord(courseName);
    }

    @Override
    public String getCollegeName(CourseDto courseDto) {
        return courseMapper.getCollegeName(courseDto);
    }
}
