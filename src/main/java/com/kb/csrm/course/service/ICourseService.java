package com.kb.csrm.course.service;
import com.kb.csrm.course.dto.CourseDto;

import java.util.List;
import java.util.Map;

public interface ICourseService {

    /**
     * 添加新用户
     * @param
     */
    void insertCourse (CourseDto courseDto);

    /**
     * 按ID查找用户
     * @param courseId
     * @return
     */
    CourseDto selectCourseById (int courseId);

    /**
     * 按ID删除用户
     * @param courseId
     * @return
     */
    CourseDto deleteCourseById (int courseId);

    /**
     * 按ID修改用户信息
     * @param courseId
     * @return
     */
    CourseDto updateCourseById (Long courseId);

}
