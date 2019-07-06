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
    public ResourceDto selectResourceById(Long resourceId) {
        return resourceMapper.selectResourceById(resourceId);
    }

    @Override
    public ResourceDto deleteResourceById(Long resourceId) {
        return resourceMapper.deleteResourceById(resourceId);
    }

    @Override
    public ResourceDto updateResourceById(Long resourceId) {
        return resourceMapper.updateResourceById(resourceId);
    }
}
