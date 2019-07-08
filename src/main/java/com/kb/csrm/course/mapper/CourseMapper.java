package com.kb.csrm.course.mapper;

import com.kb.csrm.course.dto.CourseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

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
