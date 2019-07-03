package com.kb.csrm.college.mapper;

import com.kb.csrm.college.dto.CollegeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface CollegeMapper {

    /**
     *根据院校名称或院校id验证院校是否唯一
     * @param map
     * @return
     */
    List<CollegeDto> getCollegeByCon(Map<String,Object> map);

    /**
     * 分页查询所有院校
     * @param spage
     * @param epage
     */
    List<CollegeDto> queryCollegeList(@Param("spage")int spage,@Param("epage")int epage);

    /**
     * 统计所有院校数量
     */
    int getCollegeCount();

    /**
     * 添加新学院
     * @param college
     */
    int insertCollege(CollegeDto college);

    /**
     * 根据ID查询学院
     * @param collegeId
     * @return
     */
    CollegeDto selectCollegeById(@Param(value = "collegeId") double collegeId);

    /**
     * 查询所有学院
     */
    List<CollegeDto> queryAllCollege();

    /**
     * 更新学院信息
     * @param collegeDto
     * @return
     */
    int updateCollege(CollegeDto collegeDto);

    /**
     * 删除学院
     * @param collegeId
     */
    int deleteCollege(@Param(value = "collegeId")double collegeId);


}

