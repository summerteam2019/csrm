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
    CourseDto deleteCourseById(@Param(value = "courseID") int courseId);

    /**
     * 根据ID修改课程信息
     * @param courseId
     * @return
     */
    CourseDto updateCourseById(@Param(value = "courseID") int courseId);


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
}
