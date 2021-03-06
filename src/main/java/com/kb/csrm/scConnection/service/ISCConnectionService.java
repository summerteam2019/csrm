/**
 * 选课模块服务层接口
 *
 * @author zengjiajin
 * @version 1.0
 * @date 2019/07/05
 */
package com.kb.csrm.scConnection.service;

import com.kb.csrm.course.dto.CourseDto;
import com.kb.csrm.scConnection.dto.SCConnectionDto;

import java.util.List;

public interface ISCConnectionService {

    /**
     * 根据用户ID获取选课信息
     * @param userId
     * @return
     */
    List<CourseDto> getSCConnectionByUserId(int userId);

    /**
     * 根据课程ID获取选课信息
     * @param courseId
     * @return
     */
    List<SCConnectionDto> getSCConnectionByCourseId(int courseId);

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
     * 查询该用户是否已选课
     * @param userId
     * @param courseId
     */
    int ifChoose(long userId, long courseId);
}
