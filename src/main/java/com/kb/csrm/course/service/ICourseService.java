package com.kb.csrm.course.service;
import com.kb.csrm.course.dto.CourseDto;

import java.util.List;
import java.util.Map;

public interface ICourseService {

    /**
     * 获取全部课程
     * @return
     */
    List<CourseDto> getAllCourse();

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
    void deleteCourseById (int courseId);

    /**
     * 按ID修改用户信息
     * @param courseId
     * @return
     */
    void updateCourseById (Long courseId);
    void updateCourseById (CourseDto courseId);

    /**
     * 根据关键字查询课程
     * @param courseName
     * @return
     */
    List<CourseDto> getCourseByKeyWord(String courseName);

    /**
     * 获取课程对应的学校名
     * @param courseDto
     * @return
     */
    String getCollegeName(CourseDto courseDto);


    /**
     * 获取推荐课程
     * @return
     */
    List<CourseDto> getRecommendedCourse();

    /**
     * 获取学生已选课程
     * @param userId
     * @return
     */
    List<CourseDto> getChosenCourse(Long userId);
}
