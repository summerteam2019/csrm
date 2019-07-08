package com.kb.csrm.college.service.impl;

import com.kb.csrm.college.dto.CollegeDto;
import com.kb.csrm.college.mapper.CollegeMapper;
import com.kb.csrm.college.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements ICollegeService {

    @Autowired
    private CollegeMapper collegeMapper;
    @Override
    public List<CollegeDto> getAllCollege(){
        System.out.println(collegeMapper.getAllCollege());
        return collegeMapper.getAllCollege();
    }

    @Override
    public CollegeDto getCollegeById(int collegeId){
        return collegeMapper.getCollegeById(collegeId);
    }

    @Override
    public List<CollegeDto> getCollegeByName(String collegeName){
        return collegeMapper.getCollegeByName(collegeName);
    }

    @Override
    public void addCollege(CollegeDto collegeDto){
        collegeMapper.addCollege(collegeDto);
    }

    @Override
    public void deleteCollege(int collegeId){
        CollegeDto collegeDto = new CollegeDto();
        collegeDto.setCollegeId(collegeId);
        collegeMapper.deleteCollege(collegeDto);
    }

    @Override
    public void updateCollege(CollegeDto collegeDto){
        collegeMapper.updateCollege(collegeDto);
    }
}
