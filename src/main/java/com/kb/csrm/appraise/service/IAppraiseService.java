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
    AppraiseDto getAppraiseById(int appraiseId);

    /**
     * 根据用户ID获取评论
     * @param userId
     * @return
     */
    AppraiseDto getAppraiseByUserId(int userId);

    /**
     * 根据课程ID获取评论
     * @param courseId
     * @return
     */
    AppraiseDto getAppraiseByCourseId(int courseId);

    /**
     * 获取评论用户的用户名
     * @param appraiseDto
     * @return
     */
    String getAppraiseUser(AppraiseDto appraiseDto);

    /**
     * 获取评论课程的课程名
     * @param appraiseDto
     * @return
     */
    String getAppraiseCourse(AppraiseDto appraiseDto);

    /**
     * 根据关键字获取评论
     * @param keyWord
     * @return
     */
    List<AppraiseDto> getAppraiseByKeyWord(String keyWord);
    /**
     * 添加评论
     * @param appraiseDto
     */
    void addAppraise(AppraiseDto appraiseDto);

    /**
     * 删除评论
     * @param appraiseId
     */
    void deleteAppraise(int appraiseId);

    /**
     * 编辑评论
     * @param appraiseDto
     */
    void updateAppraise(AppraiseDto appraiseDto);
}
