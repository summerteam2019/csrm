package com.kb.csrm.college.service;

import com.kb.csrm.college.dto.CollegeDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ICollegeService {

    /**
     * 根据学院名称或学院id验证是否唯一
     * @param map
     * @return
     */
    boolean validCollege(Map<String,Object> map);

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
    CollegeDto selectCollegeById(double collegeId);

    /**
     * 查询所有学院
     * @return
     */
    List<CollegeDto> queryAllCollege();

    /**
     * 分页查询所有学院
     * @param spage
     * @param epage
     * @return
     */
    List<CollegeDto> queryCollegeList(int spage,int epage);

    /**
     * 统计学院总数
     * @return
     */
    int getCollegeCount();

    /**
     * 更新学院信息
     * @param collegeDto
     * @return
     */
    int updateCollege(CollegeDto collegeDto, HttpServletRequest request);

    /**
     * 删除学院
     * @param collegeId
     */
    int deleteCollege(double collegeId);
}

