/**
 * The type ServiceRequesy.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class ServiceRequest implements IRequest {
    private static final String ATTR_USER_ID = "_userId";
    private static final String ATTR_ROLE_ID = "_roleName";
    private static final String ATTR_COMPANY_ID = "_companyId";
    private static final String ATTR_LOCALE = "_locale";
    private static final long serialVersionUID = 3699668645012922404L;
    private Long userId = -1L;
    private String roleName;
    private String[] roleNames = new String[0];
    private Long companyId = -1L;
    private String locale = Locale.getDefault().toString();
    private String employeeCode;
    private String userName;
    @JsonIgnore
    private Map<String, Object> attributeMap = new HashMap();

    public ServiceRequest() {
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public Long getUserId() {
        return this.userId;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
        this.setAttribute("_userId", userId);
    }

    @Override
    public String getRoleName() {
        return this.roleName;
    }

    @Override
    public String[] getAllRoleName() {
        return this.roleNames;
    }

    @Override
    public void setAllRoleName(String[] roleNames) {
        this.roleNames = roleNames;
    }

    @Override
    public void setRoleName(String roleName) {
        this.roleName = roleName;
        this.setAttribute("_roleName", roleName);
    }

    @Override
    @JsonAnyGetter
    public <T> T getAttribute(String name) {
        return (T) this.attributeMap.get(name);
    }

    @Override
    @JsonAnySetter
    public void setAttribute(String name, Object value) {
        this.attributeMap.put(name, value);
    }

    @Override
    @JsonIgnore
    public Map<String, Object> getAttributeMap() {
        return this.attributeMap;
    }

    @Override
    @JsonIgnore
    public Set<String> getAttributeNames() {
        return this.attributeMap.keySet();
    }
}
