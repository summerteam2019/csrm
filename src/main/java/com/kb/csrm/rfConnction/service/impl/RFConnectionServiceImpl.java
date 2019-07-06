package com.kb.csrm.rfConnction.service.impl;

import com.kb.csrm.rfConnction.dto.RFConnectionDto;
import com.kb.csrm.rfConnction.mapper.RFConnectionMapper;
import com.kb.csrm.rfConnction.service.IRFConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RFConnectionServiceImpl implements IRFConnectionService {

    @Autowired
    private RFConnectionMapper rfConnectionMapper;

    @Override
    public List<RFConnectionDto> getRFConnectionById(Integer rfConnectionId){
        return rfConnectionMapper.getRFConnectionById(rfConnectionId);
    }

    @Override
    public List<RFConnectionDto> getRFConnectionByRoleName(String roleName){
        return rfConnectionMapper.getRFConnectionByRoleName(roleName);
    }

    @Override
    public void updateRFConnection(RFConnectionDto rfConnectionDto){
        rfConnectionMapper.updateRFConnection(rfConnectionDto);
    }

    @Override
    public void deleteRFConnection(RFConnectionDto rfConnectionDto){
        rfConnectionMapper.deleteRFConnection(rfConnectionDto);
    }

   @Override
    public void addRFConnection(RFConnectionDto rfConnectionDto){
        rfConnectionMapper.addRFConnection(rfConnectionDto);
   }
}
