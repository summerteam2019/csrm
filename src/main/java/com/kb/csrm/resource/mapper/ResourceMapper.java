/**
 * 资源模块Mapper
 *
 * @author chenkaiguo
 * @version 1.0
 * @date 2019/07/06
 */
package com.kb.csrm.resource.mapper;

import com.kb.csrm.resource.dto.ResourceDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ResourceMapper {

    /**
     * 添加新资源
     * @param resource
     */
    void addResource(ResourceDto resource);

    /**
     * 根据课程名获取资源
     * @param courseName
     * @return
     */
    List<ResourceDto> getResourceByCourseName(String courseName);

    /**
     * 获取所有资源
     * @return
     */
    List<ResourceDto> getAllResource();

    /**
     * 根据ID查询资源
     * @param resourceId
     * @return
     */
    ResourceDto selectResourceById(int resourceId);

    /**
     * 根据课程ID获取资源
     * @param courseId
     * @return
     */
    List<ResourceDto> getResourceByCourseId(int courseId);

    /**
     * 获取资源上传者的用户名
     * @param resourceDto
     * @return
     */
    String getUserName(ResourceDto resourceDto);

    /**
     * 获取资源对应的课程
     * @param resourceDto
     * @return
     */
    String getCourseName(ResourceDto resourceDto);

    /**
     * 根据ID删除资源
     * @param resourceId
     * @return
     */
    ResourceDto deleteResource(int resourceId);

    /**
     * 根据ID修改资源信息
     * @param resourceId
     * @return
     */
    ResourceDto updateResourceById(@Param(value = "resourceId") int resourceId);

}
