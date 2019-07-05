package com.kb.csrm.appraise.service.impl;

import com.kb.csrm.appraise.dto.AppraiseDto;
import com.kb.csrm.appraise.mapper.AppraiseMapper;
import com.kb.csrm.appraise.service.IAppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppraiseServiceImpl implements IAppraiseService {

    @Autowired
    private AppraiseMapper appraiseMapper;

    @Override
    public List<AppraiseDto> getAllAppraise(){
        return appraiseMapper.getAllAppraise();
    }

    @Override
    public AppraiseDto getAppraiseById(Integer appraiseId){
        return appraiseMapper.getAppraiseById(appraiseId);
    }

    @Override
    public AppraiseDto getAppraiseByUserId(Integer userId){
        return appraiseMapper.getAppraiseByUserId(userId);
    }

    @Override
    public AppraiseDto getAppraiseByCourseId(Integer courseId){
        return appraiseMapper.getAppraiseByCourseId(courseId);
    }

    @Override
    public void addAppraise(AppraiseDto appraiseDto){
        appraiseMapper.addAppraise(appraiseDto);
    }

    @Override
    public void deleteAppraise(Integer appraiseId){
        appraiseMapper.deleteAppraise(appraiseId);
    }

    @Override
    public void updateAppraise(AppraiseDto appraiseDto){
        appraiseMapper.updateAppraise(appraiseDto);
    }
}
