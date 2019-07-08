package com.kb.csrm.function.mapper;

import com.kb.csrm.function.dto.FunctionDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface FunctionMapper {

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
     * 根据名称获取功能
     * @param functionName
     * @return
     */
    FunctionDto getFunctionByName(String functionName);

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
