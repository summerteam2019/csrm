package com.kb.csrm.appraise.mapper;

import com.kb.csrm.appraise.dto.AppraiseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppraiseMapper {
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
