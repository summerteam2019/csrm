/**
 * 资源模块服务实体类
 *
 * @author chenkaiguo
 * @version 1.0
 * @date 2019/07/06
 */
package com.kb.csrm.resource.service.impl;

import com.kb.csrm.resource.dto.ResourceDto;
import com.kb.csrm.resource.mapper.ResourceMapper;
import com.kb.csrm.resource.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
@Service
public class ResourceServiceImpl implements IResourceService{

    private final Path rootLocation = Paths.get("resource");

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public void addResource(ResourceDto resourceDto) {
        resourceMapper.addResource(resourceDto);
    }

    @Override
    public List<ResourceDto> getAllResource(){
        return resourceMapper.getAllResource();
    }

    @Override
    public ResourceDto selectResourceById(int resourceId) {
        return resourceMapper.selectResourceById(resourceId);
    }

    @Override
    public List<ResourceDto> getResourceByCourseName(String courseName){
        return resourceMapper.getResourceByCourseName(courseName);
    }

    @Override
    public List<ResourceDto> getResourceByCourseId(int courseId){
        return resourceMapper.getResourceByCourseId(courseId);
    }

    @Override
    public String getUserName(ResourceDto resourceDto){
        return resourceMapper.getUserName(resourceDto);
    }

    @Override
    public String getCourseName(ResourceDto resourceDto){
        return resourceMapper.getCourseName(resourceDto);
    }

    @Override
    public ResourceDto deleteResource(int resourceId) {
        return resourceMapper.deleteResource(resourceId);
    }

    @Override
    public ResourceDto updateResourceById(int resourceId) {
        return resourceMapper.updateResourceById(resourceId);
    }

    @Override
    public void uploadResource(MultipartFile file){
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try
        {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e)
        {

        }
    }

    @Override
    public Resource loadResource(String filename){
        try
        {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable())
            {
                return resource;
            }
        }
        catch (MalformedURLException e)
        {

        }
        return null;
    }
}
