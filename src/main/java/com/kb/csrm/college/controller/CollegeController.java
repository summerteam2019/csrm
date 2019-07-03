package com.kb.csrm.college.controller;
import com.kb.csrm.college.dto.CollegeDto;
import com.kb.csrm.college.service.ICollegeService;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private ICollegeService collegeService;

    @RequestMapping("goCollege.action")
    public String goCollegePage(){
        return "college";
    }

    @ResponseBody
    @RequestMapping("/valid.action")
    public Map<String,Object> validDept(
            @RequestParam("name")String name,
            @RequestParam(value="id",defaultValue="0",required=false)Integer id){

        Map<String,Object>map=new HashMap<String,Object>();
        map.put("name", name);
        map.put("id", id);
        boolean flag=collegeService.validCollege(map);

        Map<String,Object>maps=new HashMap<String,Object>();
        if(flag){
            maps.put("i", 1);
            maps.put("msg", "此学院名称可用");
        }else{
            maps.put("i", 0);
            maps.put("msg", "此学院名称不可用");
        }
        return maps;
    }

    @ResponseBody
    @RequestMapping("/collegeList.action")
    public Map<String,Object> queryCollegeListByPages(
            @RequestParam(value="pageNumber",defaultValue="1",required=false)int pageNumber,
            @RequestParam("pageSize")int pageSize){

        Map<String,Object>map = new HashMap<String, Object>();
        int count = collegeService.getCollegeCount();
        List<CollegeDto>clist=collegeService.queryCollegeList((pageNumber-1)*pageSize, pageSize);
        map.put("total", count);
        map.put("rows", clist);
        return map;
    }


    @RequestMapping("/create.action")
    @ResponseBody
    public int createCollege(@RequestBody CollegeDto collegeDto, HttpServletRequest request){

        return collegeService.insertCollege(collegeDto);
    }

    @RequestMapping("/selectOne.action")
    @ResponseBody
    public CollegeDto selectCollegeById(@RequestBody double collegeId, HttpServletRequest request){

        return collegeService.selectCollegeById(collegeId);
    }

    @RequestMapping("/queryAllCollege.action")
    @ResponseBody
    public List<CollegeDto> queryAllCollege(){

        return collegeService.queryAllCollege();
    }

    @RequestMapping("/updateCollege.action")
    @ResponseBody
    public int updateCollege(CollegeDto collegeDto, HttpServletRequest request){
        int i = collegeService.updateCollege(collegeDto,request);
        return i;
    }

    @RequestMapping("/deleteCollege.action")
    @ResponseBody
    public int deleteCollege(@RequestParam("cid")double id){
        int i = collegeService.deleteCollege(id);
        return i;
    }

}
