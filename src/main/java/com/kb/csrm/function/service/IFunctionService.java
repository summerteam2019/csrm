package com.kb.csrm.function.service;

import com.kb.csrm.function.dto.FunctionDto;

import java.util.List;

public interface IFunctionService {

    /**
     * 获取所有功能
     * @return
     */
    List<FunctionDto> getAllFunction();

    /**
     * 根据ID获取功能
     * @param functionId
     * @return
     */
    FunctionDto getFunctionById(int functionId);

    /**
     * 添加功能
     * @param functionDto
     */
    void addFunction(FunctionDto functionDto);

    /**
     * 删除功能
     * @param functionId
     */
    void deleteFunction(int functionId);

    /**
     * 编辑功能
     * @param functionDto
     */
    void updateFunction(FunctionDto functionDto);
}