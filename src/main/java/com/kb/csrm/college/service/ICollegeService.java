package com.kb.csrm.college.service;

import com.kb.csrm.college.dto.CollegeDto;

import java.util.List;

public interface ICollegeService {
    /**
     * 获取所有院校
     * @return
     */
    List<CollegeDto> getAllCollege();

    /**
     * 根据ID获取院校
     * @param collegeId
     * @return
     */
    CollegeDto getCollegeById(int collegeId);

    /**
     * 添加院校
     * @param collegeDto
     */
    void addCollege(CollegeDto collegeDto);

    /**
     * 删除院校
     * @param collegeId
     */
    void deleteCollege(int collegeId);

    /**
     * 编辑院校
     * @param collegeDto
     */
    void updateCollege(CollegeDto collegeDto);

}
