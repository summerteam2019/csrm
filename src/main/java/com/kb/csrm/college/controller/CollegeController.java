/**
 * The type CollegeController
 *
 * @author 曾佳进 714705217@qq.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.college.controller;

import com.kb.csrm.college.dto.CollegeDto;
import com.kb.csrm.college.service.ICollegeService;
import com.kb.csrm.util.BaseController;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/college")
public class CollegeController extends BaseController {

    @Autowired
    private ICollegeService collegeService;

    /**
     * 获取所有学校
     * @param modelMap
     * @return
     */
    @RequestMapping(path="/getAllCollege")
    @ResponseBody
    public List<CollegeDto> getAllCollege(ModelMap modelMap){
        List<CollegeDto> collegeList = collegeService.getAllCollege();
        modelMap.addAttribute("collegeList",collegeList);
        return collegeList;
    }

    /**
     * 根据学校名查询学校
     * @param collegeName
     * @return
     */
    @RequestMapping(path="/getCollegeByName")
    @ResponseBody
    public List<CollegeDto> getCollegeByName(String collegeName){
        List<CollegeDto> collegeList = collegeService.getCollegeByName(collegeName);
        return collegeList;
    }

    /**
     * 根据学校ID查询学校
     * @param collegeDto
     * @return
     */
    @RequestMapping("/getCollegeById")
    @ResponseBody
    public CollegeDto getCollegeById(CollegeDto collegeDto){
        int collegeId = collegeDto.getCollegeId();
        return collegeService.getCollegeById(collegeId);
    }

    /**
     * 添加新学校
     * @param collegeId
     * @param collegeName
     * @param facultyName
     * @return
     */
    @RequestMapping("/addCollege")
    @ResponseBody
    public Boolean addCollege(int collegeId, String collegeName, String facultyName){
        CollegeDto collegeDto = new CollegeDto();
        collegeDto.setCollegeId(collegeId);
        collegeDto.setCollegeName(collegeName);
        collegeDto.setFacultyName(facultyName);
        collegeService.addCollege(collegeDto);
        return true;
    }

    /**
     * 删除学校
     * @param collegeId
     * @return
     */
    @RequestMapping("/deleteCollege")
    @ResponseBody
    public boolean deleteCollege(@RequestParam("collegeId") int collegeId){
        collegeService.deleteCollege(collegeId);
        return true;
    }

    /**
     * 修改学校信息
     * @param collegeId
     * @param collegeName
     * @param facultyName
     * @return
     */
    @RequestMapping("/updateCollege")
    @ResponseBody
    public boolean updateCollege(@RequestParam("collegeId") int collegeId, @RequestParam("collegeName")String collegeName, @RequestParam("facultyName")String facultyName){
        CollegeDto collegeDto = new CollegeDto();
        collegeDto.setCollegeId(collegeId);
        collegeDto.setCollegeName(collegeName);
        collegeDto.setFacultyName(facultyName);
        collegeService.updateCollege(collegeDto);
        return true;
    }
}
