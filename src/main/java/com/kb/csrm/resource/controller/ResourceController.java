package com.kb.csrm.resource.controller;
import com.kb.csrm.resource.dto.ResourceDto;
import com.kb.csrm.resource.service.IResourceService;
import com.kb.csrm.util.BaseController;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/resource")

public class ResourceController extends BaseController{
    @Autowired
    private IResourceService resourceService;

    @RequestMapping("/create")
    @ResponseBody
    public ResponseData insertResource(@RequestBody ResourceDto resourceDto, HttpServletRequest request){
        resourceService.insertResource(resourceDto);
        return new ResponseData(true);
    }

    @RequestMapping("/getAllResource")
    @ResponseBody
    public Object[] getAllResource(){
        Object[] allResource = new Object[3];
        List<ResourceDto> resourceList = resourceService.getAllResource();
        String[] userName = new String[resourceList.size()];
        String[] courseName = new String[resourceList.size()];
        for(int i = 0; i < resourceList.size(); i++){
            userName[i] = resourceService.getUserName(resourceList.get(i));
            courseName[i] = resourceService.getCourseName(resourceList.get(i));
        }
        allResource[0] = resourceList;
        allResource[1] = userName;
        allResource[2] = courseName;
        return allResource;
    }


    @RequestMapping("/select")
    @ResponseBody
    public ResourceDto selectResourceById(ResourceDto resourceDto){
        int resourceId = resourceDto.getResourceId();
        return resourceService.selectResourceById(resourceId);
    }

    @RequestMapping("/getResourceByCourseName")
    @ResponseBody
    public Object[] getResourceByCourseName(String courseName){
        Object[] allResource = new Object[3];
        List<ResourceDto> resourceList = resourceService.getResourceByCourseName(courseName);
        String[] userName = new String[resourceList.size()];
        for(int i = 0; i < resourceList.size(); i++){
            userName[i] = resourceService.getUserName(resourceList.get(i));
        }
        allResource[0] = resourceList;
        allResource[1] = userName;
        allResource[2] = courseName;
        return allResource;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean deleteResourceById(int resourceId){
        resourceService.deleteResource(resourceId);
        return true;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updateResourceById(@RequestBody Long resourceId, HttpServletRequest request){
        resourceService.updateResourceById(resourceId);
        return new ResponseData(true);
    }

}
