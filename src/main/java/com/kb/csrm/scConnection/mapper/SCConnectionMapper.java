package com.kb.csrm.scConnection.mapper;

import com.kb.csrm.course.dto.CourseDto;
import com.kb.csrm.scConnection.dto.SCConnectionDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface SCConnectionMapper {

    /**
     * 根据用户ID获取选课信息
     * @param userId
     * @return
     */
    List<CourseDto> getCourseByUserId(long userId);

    /**
     * 根据课程ID获取选课信息
     * @param courseId
     * @return
     */
    List<SCConnectionDto> getSCConnectionByCourseId(Integer courseId);

    /**
     * 添加选课
     * @param scConnectionDto
     */
    void addSCConnection(SCConnectionDto scConnectionDto);

    /**
     * 删除选课
     * @param scConnectionDto
     */
    void deleteSCConnection(SCConnectionDto scConnectionDto);

    /**
     * 查询该用户是否选择了该课程
     * @param userId
     * @param courseId
     * @return
     */
    int ifChoose(@Param("userId") long userId,@Param("courseId") long courseId);
}
