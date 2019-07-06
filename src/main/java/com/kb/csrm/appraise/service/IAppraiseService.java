package com.kb.csrm.appraise.service;

import com.kb.csrm.appraise.dto.AppraiseDto;

import java.util.List;

public interface IAppraiseService {

    /**
     * 获取所有评论
     * @return
     */
    List<AppraiseDto> getAllAppraise();

    /**
     * 根据ID获取评论
     * @param appraiseId
     * @return
     */
    AppraiseDto getAppraiseById(Integer appraiseId);

    /**
     * 根据用户ID获取评论
     * @param userId
     * @return
     */
    AppraiseDto getAppraiseByUserId(Integer userId);

    /**
     * 根据课程ID获取评论
     * @param courseId
     * @return
     */
    AppraiseDto getAppraiseByCourseId(Integer courseId);

    /**
     * 添加评论
     * @param appraiseDto
     */
    void addAppraise(AppraiseDto appraiseDto);

    /**
     * 删除评论
     * @param appraiseId
     */
    void deleteAppraise(Integer appraiseId);

    /**
     * 编辑评论
     * @param appraiseDto
     */
    void updateAppraise(AppraiseDto appraiseDto);
}
