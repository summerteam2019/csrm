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
}
