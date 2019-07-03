package com.kb.csrm.college.service.impl;

import com.kb.csrm.college.dto.CollegeDto;
import com.kb.csrm.college.mapper.CollegeMapper;
import com.kb.csrm.college.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class CollegeServiceImpl implements ICollegeService{

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public boolean validCollege(Map<String,Object> map) {
        boolean flag=true;
        List<CollegeDto>list=collegeMapper.getCollegeByCon(map);
        int x=(Integer)map.get("id");

        if(x!=0){//修改
            if((list.size()==1&&x==list.get(0).getCollegeId())){
                flag=true;
            }else if(list.size()==0){
                flag=true;
            }else{
                flag=false;
            }
        }else{//添加
            if(list.size()>0){
                flag=false;
            }
        }
        return flag;
    }

    @Override
    public int insertCollege(CollegeDto college){

        return collegeMapper.insertCollege(college);
    }

    @Override
    public CollegeDto selectCollegeById(double collegeId){
        return collegeMapper.selectCollegeById(collegeId);
    }

    @Override
    public List<CollegeDto> queryAllCollege(){
        return collegeMapper.queryAllCollege();
    }

    @Override
    public List<CollegeDto> queryCollegeList(int spage,int epage){
        return collegeMapper.queryCollegeList(spage, epage);
    }

    @Override
    public int getCollegeCount(){
        return collegeMapper.getCollegeCount();
    }

    @Override
    public int updateCollege(CollegeDto collegeDto, HttpServletRequest request){
        int i = collegeMapper.updateCollege(collegeDto);
        return i;
    }

    @Override
    public int deleteCollege(double collegeId){
        int i = collegeMapper.deleteCollege(collegeId);
        return i;
    }
}

