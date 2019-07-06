package com.kb.csrm.course.service;
import com.kb.csrm.course.dto.CourseDto;

import java.util.Map;

public interface ICourseService {
    /**
     * 根据学院名称或学院id验证是否唯一
     * @param map
     * @return
     */
    boolean validCourse(Map<String,Object> map);

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
    CourseDto selectCourseById (Long courseId);

    /**
     * 按ID删除用户
     * @param courseId
     * @return
     */
    void deleteCourseById (Long courseId);

    /**
     * 按ID修改用户信息
     * @param courseId
     * @return
     */
    void updateCourseById (Long courseId);

}
