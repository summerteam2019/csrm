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
    public AppraiseDto getAppraiseById(int appraiseId){
        return appraiseMapper.getAppraiseById(appraiseId);
    }

    @Override
    public String getAppraiseUser(AppraiseDto appraiseDto){
        String userName = appraiseMapper.getAppraiseUser(appraiseDto);
        return userName;
    }

    @Override
    public String getAppraiseCourse(AppraiseDto appraiseDto){
        String courseName = appraiseMapper.getAppraiseCourse(appraiseDto);
        return courseName;
    }

    @Override
    public List<AppraiseDto> getAppraiseByKeyWord(String keyWord){
        return appraiseMapper.getAppraiseByKeyWord(keyWord);
    }

    @Override
    public List<AppraiseDto> getAppraiseByUserId(int userId){
        return appraiseMapper.getAppraiseByUserId(userId);
    }

    @Override
    public List<AppraiseDto> getAppraiseByCourseId(int courseId){
        return appraiseMapper.getAppraiseByCourseId(courseId);
    }

    @Override
    public AppraiseDto getAppraiseByUserAndCourse(int userId, int courseId){
        return appraiseMapper.getAppraiseByUserAndCourse(userId, courseId);
    }

    @Override
    public void addAppraise(AppraiseDto appraiseDto){
        appraiseMapper.addAppraise(appraiseDto);
    }

    @Override
    public void deleteAppraise(int appraiseId){
        appraiseMapper.deleteAppraise(appraiseId);
    }

    @Override
    public void updateAppraise(AppraiseDto appraiseDto){
        appraiseMapper.updateAppraise(appraiseDto);
    }
}
