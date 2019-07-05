package com.kb.csrm.appraise.mapper;

import com.kb.csrm.appraise.dto.AppraiseDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AppraiseMapper {

    /**
     * 获取所有评论
     * @return
     */
    @Select("select * from appraise")
    List<AppraiseDto> getAllAppraise();

    /**
     * 根据ID获取评论
     * @param appraiseId
     * @return
     */
    @Select("select * from appraise where appraise_id = #{appraiseId}")
    AppraiseDto getAppraiseById(int appraiseId);

    /**
     * 根据用户ID获取评论
     * @param userId
     * @return
     */
    @Select("select * from appraise where user_id = #{userId}")
    AppraiseDto getAppraiseByUserId(int userId);

    /**
     * 根据课程ID获取评论
     * @param courseId
     * @return
     */
    @Select("select * from appraise where course_id = #{courseId}")
    AppraiseDto getAppraiseByCourseId(int courseId);

    /**
     * 添加评论
     * @param appraiseDto
     */
    @Insert("insert into appraise values (#{appraiseId},#{userId},#{courseId},#{appraiseGrade},#{appraiseContent},#{appraiseTime},#{appraiseRaise})")
    void addAppraise(AppraiseDto appraiseDto);

    /**
     * 删除评论
     * @param appraiseId
     */
    @Delete("delete from appraise where appraise_id = #{appraiseId}")
    void deleteAppraise(int appraiseId);

    /**
     * 编辑评论
     * @param appraiseDto
     */
    @Update("update appraise set user_id = #{userId},course_id = #{courseId},appraise_grade = #{appraiseGrade},appraise_content = #{appraiseContent},appraise_time = #{appraiseTime},appraise_raise = #{appraiseRaise} where appraise_id = #{appraiseId}")
    void updateAppraise(AppraiseDto appraiseDto);
}
