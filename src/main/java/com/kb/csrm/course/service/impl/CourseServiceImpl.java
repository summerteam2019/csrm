/**
 * The type CourseServiceImpl
 *
 * @author 陈开国 & 曾佳进714705217@qq.com & yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/7/11
 */


package com.kb.csrm.course.service.impl;

import com.kb.csrm.course.dto.CourseDto;
import com.kb.csrm.course.mapper.CourseMapper;
import com.kb.csrm.course.service.ICourseService;
import com.kb.csrm.scConnection.mapper.SCConnectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private SCConnectionMapper scConnectionMapper;

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
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(courseId);
        CourseDto courseDto1 = courseMapper.selectCourseById(courseDto);
        return courseDto1;
    }

    @Override
    public void deleteCourseById(int courseId) {
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(courseId);
        courseMapper.deleteCourseById(courseDto);
    }


    @Override
    public List<CourseDto> getRecommendedCourse() {
        return courseMapper.getRecommend();
    }

    @Override
    public List<CourseDto> getChosenCourse(Long userId) {
        return scConnectionMapper.getCourseByUserId(userId);
    }

    @Override
    public List<CourseDto> getHighCount(int num) {
        return  courseMapper.getHighCount(num);
    }

    @Override
    public List<CourseDto> getTaughtCourse(Long userId) {
        return courseMapper.getTaughtCourse(userId);
    }

    @Override
    public void updateCourseById(CourseDto courseDto) {
        courseMapper.updateCourseById(courseDto);
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
