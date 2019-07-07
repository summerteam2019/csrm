package com.kb.csrm.resource.service;
import com.kb.csrm.resource.dto.ResourceDto;

import java.util.List;
public interface IResourceService {
    /**
     * 添加新资源
     * @param
     */
    void insertResource (ResourceDto resourceDto);

    /**
     * 按ID查找资源
     * @param
     * @return
     */
    ResourceDto selectResourceById (int resourceId);

    /**
     * 按ID删除资源
     * @param
     * @return
     */
    ResourceDto deleteResourceById (int resourceId);

    /**
     * 按ID修改资源信息
     * @param
     * @return
     */
    ResourceDto updateResourceById (Long resourceId);
}
