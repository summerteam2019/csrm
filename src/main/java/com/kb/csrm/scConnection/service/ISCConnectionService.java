package com.kb.csrm.scConnection.service;

import com.kb.csrm.scConnection.dto.SCConnectionDto;

import java.util.List;

public interface ISCConnectionService {

    /**
     * 根据用户ID获取选课信息
     * @param userId
     * @return
     */
    List<SCConnectionDto> getSCConnectionByUserId(Integer userId);

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
}
