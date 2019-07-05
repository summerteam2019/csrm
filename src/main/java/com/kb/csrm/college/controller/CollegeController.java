package com.kb.csrm.college.controller;

import com.kb.csrm.college.dto.CollegeDto;
import com.kb.csrm.college.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private ICollegeService collegeService;

    @RequestMapping(path="/getAllCollege.do" ,produces="application/json;charset=utf-8")
    public List<CollegeDto> getAllCollege(ModelMap modelMap){
        List<CollegeDto> collegeList = collegeService.getAllCollege();
        modelMap.addAttribute("collegeList",collegeList);
        System.out.println(collegeList);
        return collegeList;
    }

    @RequestMapping("/getCollegeById.do")
    public CollegeDto getCollegeById(int collegeId){
        return collegeService.getCollegeById(collegeId);
    }

    @RequestMapping("/addCollege.do")
    public void addCollege(int collegeId, String collegeName, String facultyName){
        CollegeDto collegeDto = new CollegeDto();
        collegeDto.setCollegeId(collegeId);
        collegeDto.setCollegeName(collegeName);
        collegeDto.setFacultyName(facultyName);
        collegeService.addCollege(collegeDto);
    }

    @RequestMapping("/deleteCollege.do")
    public void deleteCollege(Integer collegeId){
        collegeService.deleteCollege(collegeId);
    }

    @RequestMapping("/updateCollege.do")
    public void updateCollege(CollegeDto collegeDto){
        collegeService.updateCollege(collegeDto);
    }
}
