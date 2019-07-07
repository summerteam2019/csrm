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


    @RequestMapping("/select")
    @ResponseBody
    public ResourceDto selectResourceByIdById(ResourceDto resourceDto){
        int resourceId = resourceDto.getResourceId();
        return resourceService.selectResourceById(resourceId);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData deleteResourceById(@RequestBody int resourceId, HttpServletRequest request){
        resourceService.deleteResourceById(resourceId);
        return new ResponseData(true);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updateResourceById(@RequestBody Long resourceId, HttpServletRequest request){
        resourceService.updateResourceById(resourceId);
        return new ResponseData(true);
    }

}
