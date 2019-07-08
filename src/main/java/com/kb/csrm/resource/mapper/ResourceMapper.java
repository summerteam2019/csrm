package com.kb.csrm.resource.mapper;

import com.kb.csrm.resource.dto.ResourceDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface ResourceMapper {
    /**
     * 添加新资源
     * @param resource
     */
    void insertResource(ResourceDto resource);

    /**
     * 根据ID查询资源
     * @param resourceId
     * @return
     */
    ResourceDto selectResourceById(int resourceId);

    /**
     * 根据ID删除资源
     * @param resourceId
     * @return
     */
    ResourceDto deleteResourceById(int resourceId);

    /**
     * 根据ID修改资源信息
     * @param resourceId
     * @return
     */
    ResourceDto updateResourceById(@Param(value = "resourceId") double resourceId);
}
