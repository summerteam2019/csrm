/**
 * The type CollegeMapper
 *
 * @author 曾佳进714705217@qq.com & yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/7/8
 */

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
     * 根据学校名称获取院校
     * @param collegeName
     * @return
     */
    List<CollegeDto> getCollegeByName(String collegeName);

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
