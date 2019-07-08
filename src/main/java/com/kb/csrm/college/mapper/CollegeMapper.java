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
    List<CollegeDto> getAllCollege();

    /**
     * 根据ID获取院校
     *
     * @param collegeId
     * @return
     */
    CollegeDto getCollegeById(int collegeId);

    /**
     * 添加院校
     *
     * @param collegeDto
     */
    void addCollege(CollegeDto collegeDto);

    /**
     * 删除院校
     *
     * @param collegeDto
     */
    void deleteCollege(CollegeDto collegeDto);

    /**
     * 修改院校
     *
     * @param collegeDto
     */
    void updateCollege(CollegeDto collegeDto);
}
