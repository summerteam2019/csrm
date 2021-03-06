/**
 * The type ICourseService
 *
 * @author 陈开国 & 曾佳进714705217@qq.com & yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/7/11
 */


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
     * @param courseDto
     * @return
     */
    void updateCourseById (CourseDto courseDto);

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
    List<CourseDto> getChosenCourse(int userId);

    /**
     * 获取点击量最高的课程
     * @param num
     * @return
     */
    List<CourseDto> getHighCount(int num);

    /**
     * 获取教授课程
     * @param userId
     * @return
     */
    List<CourseDto> getTaughtCourse(int userId);
}
