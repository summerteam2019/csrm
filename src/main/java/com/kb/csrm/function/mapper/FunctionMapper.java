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
    @Select("select * from function_menu")
    List<FunctionDto> getAllFunction();

    /**
     * 根据ID获取功能
     * @param functionId
     * @return
     */
    @Select("select * from function_menu where function_id = #{functionId}")
    FunctionDto getFunctionById(int functionId);

    /**
     * 添加功能
     * @param functionDto
     */
    @Insert("insert into function_menu values (#{functionId},#{functionName},#{functionMeaning},#{functionUrl},#{parentId})")
    void addFunction(FunctionDto functionDto);

    /**
     * 删除功能
     * @param functionId
     */
    @Delete("delete from function_menu where function_id = #{functionId}")
    void deleteFunction(int functionId);

    /**
     * 编辑功能
     * @param functionDto
     */
    @Update("update function_menu set function_name = #{functionName}, function_meaning = #{functionMeaning}, function_url = #{functionUrl}, parent_id = #{parentId}")
    void updateFunction(FunctionDto functionDto);
}
