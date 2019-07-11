/**
 * The type CollegeController
 *
 * @author 曾佳进 714705217@qq.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

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
     * 根据名称获取院校
     * @param collegeName
     * @return
     */
    List<CollegeDto> getCollegeByName(String collegeName);

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
