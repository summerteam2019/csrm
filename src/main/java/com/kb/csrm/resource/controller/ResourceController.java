package com.kb.csrm.resource.controller;
import com.kb.csrm.resource.dto.ResourceDto;
import com.kb.csrm.resource.service.IResourceService;
import com.kb.csrm.util.BaseController;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/resource")

public class ResourceController extends BaseController{
    @Autowired
    private IResourceService resourceService;

    @RequestMapping("/addResource")
    @ResponseBody
    public boolean addResource(ResourceDto resourceDto){
        resourceService.addResource(resourceDto);
        return true;
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

    @RequestMapping("/getResourceByCourseId")
    @ResponseBody
    public List<ResourceDto> getResourceByCourseId(int courseId){
        return resourceService.getResourceByCourseId(courseId);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean deleteResourceById(int resourceId){
        resourceService.deleteResource(resourceId);
        return true;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseData updateResourceById(int resourceId){
        resourceService.updateResourceById(resourceId);
        return new ResponseData(true);
    }

    @PostMapping("/uploadResource")
    @ResponseBody
    public String resourceUpload(@RequestParam("file") MultipartFile file,
                                 RedirectAttributes redirectAttributes){
        resourceService.uploadResource(file);
        redirectAttributes.addFlashAttribute("message","You successfully uploaded " + file.getOriginalFilename() + "!");
        return "成功上传！";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = resourceService.loadResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


}
