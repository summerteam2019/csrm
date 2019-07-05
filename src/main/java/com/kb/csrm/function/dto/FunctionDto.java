package com.kb.csrm.function.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="function_menu")
public class FunctionDto {

    @Id
    @GeneratedValue(generator = "IDENTITY")
    private int functionId;

    @Column
    private String functionName;

    @Column
    private String functionMeaning;

    @Column
    private String functionUrl;

    @Column
    private int parentId;

    public int getFunctionId(){
        return functionId;
    }

    public void setFunctionId(int functionId){
        this.functionId = functionId;
    }

    public String getFunctionName(){
        return functionName;
    }

    public void setFunctionName(String functionName){
        this.functionName = functionName;
    }

    public String getFunctionMeaning(){
        return functionMeaning;
    }

    public void setFunctionMeaning(String functionMeaning){
        this.functionMeaning = functionMeaning;
    }

    public String getFunctionUrl(){
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl){
        this.functionUrl = functionUrl;
    }

    public int getParentId(){
        return parentId;
    }

    public void setParentId(int parentId){
        this.parentId = parentId;
    }
}
