package com.kb.csrm.course.mapper;

import com.kb.csrm.course.dto.CourseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CourseMapper {

    /**
     * 添加新课程
     * @param course
     */
    void insertCourse(CourseDto course);

    /**
     * 根据ID查询课程
     * @param courseId
     * @return
     */
    CourseDto selectCourseById( int  courseId);

    /**
     * 根据ID删除课程
     * @param courseId
     * @return
     */
    void deleteCourseById(@Param(value = "courseID") double courseId);

    /**
     * 根据ID修改课程信息
     * @param courseId
     * @return
     */
    CourseDto updateCourseById(@Param(value = "courseID") int courseId);

    void updateCourseById(@Param(value = "courseID") CourseDto courseId);


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
     * 获取全部课程
     * @return
     */
    List<CourseDto> getAllCourse();
    void updateCourseById(@Param(value = "courseID") double courseId);

    /**
     * 获取管理员推荐课程
     * @return
     */
    List<CourseDto> getRecommend();

    /**
     * 获取当前最高点击的n门课程
     * @return
     */
    List<CourseDto> getHighCount(@Param("num") int n);

    /**
     * 批量存储从网上获取的课程
     * @param courseList
     */
    void batchInsert(List<CourseDto> courseList);
}
