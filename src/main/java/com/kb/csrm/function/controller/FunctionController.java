package com.kb.csrm.function.controller;

import com.kb.csrm.function.dto.FunctionDto;
import com.kb.csrm.function.service.IFunctionService;
import com.sun.org.apache.xpath.internal.functions.FuncDoclocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    private IFunctionService functionService;

    @RequestMapping("/getAllFunction")
    public List<FunctionDto> getAllFunction(ModelMap modelMap){
        List<FunctionDto> functionList = functionService.getAllFunction();
        modelMap.addAttribute("functionList",functionList);
        return functionList;
    }

    @RequestMapping("/getFunctionById")
    public FunctionDto getFunctionById(int functionId){
        FunctionDto functionDto = functionService.getFunctionById(functionId);
        return functionDto;
    }

    @RequestMapping("/addFunction")
    public boolean addFunction(FunctionDto functionDto){
        functionService.addFunction(functionDto);
        return true;
    }

    @RequestMapping("/deleteFunction")
    public boolean deleteFunction(int functionId){
        functionService.deleteFunction(functionId);
        return true;
    }

    @RequestMapping("/updateFunction")
    public boolean updateFunction(FunctionDto functionDto){
        functionService.updateFunction(functionDto);
        return true;
    }
}
