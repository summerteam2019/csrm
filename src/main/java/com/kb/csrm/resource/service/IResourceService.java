/**
 * 资源模块服务类接口
 *
 * @author chenkaiguo
 * @version 1.0
 * @date 2019/07/06
 */
package com.kb.csrm.resource.service;
import com.kb.csrm.resource.dto.ResourceDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface IResourceService {

    /**
     * 添加新资源
     * @param
     */
    void addResource (ResourceDto resourceDto);

    /**
     * 获取所有资源
     * @return
     */
    List<ResourceDto> getAllResource();

    /**
     * 按ID查找资源
     * @param resourceId
     * @return
     */
    ResourceDto selectResourceById (int resourceId);

    /**
     * 根据课程名称查找资源
     * @param courseName
     * @return
     */
    List<ResourceDto> getResourceByCourseName(String courseName);

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
     * 按ID删除资源
     * @param
     * @return
     */
    ResourceDto deleteResource(int resourceId);

    /**
     * 按ID修改资源信息
     * @param
     * @return
     */
    ResourceDto updateResourceById (int resourceId);

    /**
     * 上传文件
     * @param file
     */
    void uploadResource(MultipartFile file);

    /**
     * 下载文件
     * @param filename
     * @return
     */
    Resource loadResource(String filename);

}
