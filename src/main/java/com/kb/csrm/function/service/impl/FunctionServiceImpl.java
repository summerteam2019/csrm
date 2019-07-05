package com.kb.csrm.function.service.impl;

import com.kb.csrm.function.dto.FunctionDto;
import com.kb.csrm.function.mapper.FunctionMapper;
import com.kb.csrm.function.service.IFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl implements IFunctionService {

    @Autowired
    private FunctionMapper functionMapper;

    @Override
    public List<FunctionDto> getAllFunction(){
        return functionMapper.getAllFunction();
    }

    @Override
    public FunctionDto getFunctionById(int functionId){
        return functionMapper.getFunctionById(functionId);
    }

    @Override
    public void addFunction(FunctionDto functionDto){
        functionMapper.addFunction(functionDto);
    }

    @Override
    public void deleteFunction(int functionId){
        functionMapper.deleteFunction(functionId);
    }

    @Override
    public void updateFunction(FunctionDto functionDto){
        functionMapper.updateFunction(functionDto);
    }
}
