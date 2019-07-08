package com.kb.csrm.resource.service.impl;

import com.kb.csrm.resource.dto.ResourceDto;
import com.kb.csrm.resource.mapper.ResourceMapper;
import com.kb.csrm.resource.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResourceServiceImpl implements IResourceService{
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public void insertResource(ResourceDto resourceDto) {
        resourceMapper.insertResource(resourceDto);
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
    public ResourceDto updateResourceById(Long resourceId) {
        return resourceMapper.updateResourceById(resourceId);
    }
}
