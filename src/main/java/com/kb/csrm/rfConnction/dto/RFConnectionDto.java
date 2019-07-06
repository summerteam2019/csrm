package com.kb.csrm.rfConnction.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user_function_connection")
public class RFConnectionDto {

    @Id
    @GeneratedValue(generator = "IDENTITY")
    private Integer rfConnectionId;

    @Column
    private String roleName;

    @Column
    private Integer functionId;

    public Integer getRfConnectionId(){
        return rfConnectionId;
    }
    public void setRfConnectionId(Integer rfConnectionId){
        this.rfConnectionId = rfConnectionId;
    }

    public String getRoleName(){
        return roleName;
    }
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    public Integer getFunctionId(){
        return functionId;
    }
    public void setFunctionId(Integer functionId){
        this.functionId = functionId;
    }
}
