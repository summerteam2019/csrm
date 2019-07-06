package com.kb.csrm.college.mapper;

import com.kb.csrm.college.dto.CollegeDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollegeMapper {

    /**
     * 获取所有院校
     *
     * @return
     */
    @Select("select * from college")
    List<CollegeDto> getAllCollege();

    /**
     * 根据ID获取院校
     *
     * @param collegeId
     * @return
     */
    @Select("select * from college where college_id = #{collegeId}")
    CollegeDto getCollegeById(int collegeId);

    /**
     * 添加院校
     *
     * @param collegeDto
     */
    @Insert("insert into college values (#{collegeId},#{collegeName},#{facultyName})")
    void addCollege(CollegeDto collegeDto);

    /**
     * 删除院校
     *
     * @param collegeDto
     */
    @Delete("delete from college where college_id = #{collegeId}")
    void deleteCollege(CollegeDto collegeDto);

    /**
     * 修改院校
     *
     * @param collegeDto
     */
    @Update("update college set college_name = #{collegeName}, faculty_name = #{facultyName} where college_id = #{collegeId}")
    void updateCollege(CollegeDto collegeDto);
}
