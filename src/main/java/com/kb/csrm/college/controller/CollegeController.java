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

    @RequestMapping(path="/getAllCollege")
    @ResponseBody
    public List<CollegeDto> getAllCollege(ModelMap modelMap){
        List<CollegeDto> collegeList = collegeService.getAllCollege();
        modelMap.addAttribute("collegeList",collegeList);
        return collegeList;
    }

    @RequestMapping("/getCollegeById")
    @ResponseBody
    public CollegeDto getCollegeById(CollegeDto collegeDto){
        int collegeId = collegeDto.getCollegeId();
        return collegeService.getCollegeById(collegeId);
    }

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

    @RequestMapping("/deleteCollege")
    @ResponseBody
    public boolean deleteCollege(@RequestParam("collegeId") int collegeId){
        collegeService.deleteCollege(collegeId);
        return true;
    }

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
