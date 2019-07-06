package com.kb.csrm.rfConnction.service;

import com.kb.csrm.rfConnction.dto.RFConnectionDto;

import java.util.List;

public interface IRFConnectionService {

    /**
     * 根据主键ID获取角色-功能关联
     * @param rfConnectionId
     * @return
     */
    List<RFConnectionDto> getRFConnectionById(Integer rfConnectionId);

    /**
     * 根据角色名称获取其可用功能
     * @param roleName
     * @return
     */
    List<RFConnectionDto> getRFConnectionByRoleName(String roleName);

    /**
     * 修改角色的可用功能
     * @param rfConnectionDto
     * @return
     */
    void updateRFConnection(RFConnectionDto rfConnectionDto);

    /**
     * 删除角色的一个可用功能
     * @param rfConnectionDto
     */
    void deleteRFConnection(RFConnectionDto rfConnectionDto);

    /**
     * 为角色添加功能
     * @param rfConnectionDto
     */
    void addRFConnection(RFConnectionDto rfConnectionDto);
}
