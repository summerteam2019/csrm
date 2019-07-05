package com.kb.csrm.scConnection.service.impl;

import com.kb.csrm.scConnection.dto.SCConnectionDto;
import com.kb.csrm.scConnection.mapper.SCConnectionMapper;
import com.kb.csrm.scConnection.service.ISCConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SCConnectionServiceImpl implements ISCConnectionService {

    @Autowired
    private SCConnectionMapper scConnectionMapper;

    @Override
    public List<SCConnectionDto> getSCConnectionByUserId(Integer userId){
        return scConnectionMapper.getSCConnectionByUserId(userId);
    }

    @Override
    public List<SCConnectionDto> getSCConnectionByCourseId(Integer courseId){
        return scConnectionMapper.getSCConnectionByCourseId(courseId);
    }

    @Override
    public void addSCConnection(SCConnectionDto scConnectionDto){
        scConnectionMapper.addSCConnection(scConnectionDto);
    }

    @Override
    public void deleteSCConnection(SCConnectionDto scConnectionDto){
        scConnectionMapper.deleteSCConnection(scConnectionDto);
    }
}
