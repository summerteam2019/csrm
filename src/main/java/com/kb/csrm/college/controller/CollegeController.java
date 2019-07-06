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

    @RequestMapping(path = "/getAllCollege")
    @ResponseBody
    public ResponseData getAllCollege(HttpServletRequest request) {
        List<CollegeDto> collegeList = collegeService.getAllCollege();
        return new ResponseData(collegeList);
    }

    @RequestMapping("/getCollegeById")
    @ResponseBody
    public CollegeDto getCollegeById(int collegeId) {
        return collegeService.getCollegeById(collegeId);
    }

    @RequestMapping("/addCollege")
    @ResponseBody
    public void addCollege(int collegeId, String collegeName, String facultyName) {
        CollegeDto collegeDto = new CollegeDto();
        collegeDto.setCollegeId(collegeId);
        collegeDto.setCollegeName(collegeName);
        collegeDto.setFacultyName(facultyName);
        collegeService.addCollege(collegeDto);
    }

    @RequestMapping("/deleteCollege")
    @ResponseBody
    public void deleteCollege(Integer collegeId) {
        collegeService.deleteCollege(collegeId);
    }

    @RequestMapping("/updateCollege")
    @ResponseBody
    public void updateCollege(CollegeDto collegeDto) {
        collegeService.updateCollege(collegeDto);
    }
}
