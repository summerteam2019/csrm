/**
 * 资源模块控制器
 *
 * @author chenkaiguo
 * @version 1.0
 * @date 2019/07/06
 */
package com.kb.csrm.resource.controller;

import com.kb.csrm.resource.dto.ResourceDto;
import com.kb.csrm.resource.service.IResourceService;
import com.kb.csrm.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/resource")

public class ResourceController extends BaseController{
    @Autowired
    private IResourceService resourceService;

    /**
     * 添加资源
     *
     * @param resourceDto
     * @return
     */
    @RequestMapping("/addResource")
    @ResponseBody
    public boolean addResource(ResourceDto resourceDto){
        resourceService.addResource(resourceDto);
        return true;
    }

    /**
     * 获取全部资源列表
     * @return
     */
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

    /**
     * 根据课程名称获取资源
     * @param courseName
     * @return
     */
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

    /**
     * 根据课程ID获取资源
     * @param courseId
     * @return
     */
    @RequestMapping("/getResourceByCourseId")
    @ResponseBody
    public List<ResourceDto> getResourceByCourseId(int courseId){
        return resourceService.getResourceByCourseId(courseId);
    }

    /**
     * 删除资源
     * @param resourceId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public boolean deleteResourceById(int resourceId){
        resourceService.deleteResource(resourceId);
        return true;
    }

    /**
     * 上传资源
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/uploadResource")
    @ResponseBody
    public String resourceUpload(@RequestParam("file") MultipartFile file,
                                 RedirectAttributes redirectAttributes){
        resourceService.uploadResource(file);
        redirectAttributes.addFlashAttribute("message","You successfully uploaded " + file.getOriginalFilename() + "!");
        return "成功上传！";
    }

    /**
     * 下载资源
     * @param filename
     * @return
     */
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = resourceService.loadResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


}
