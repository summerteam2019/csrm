/**
 * The type IRequest.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public interface IRequest extends Serializable {
    String FIELD_USER_ID = "userId";
    String FIELD_ROLE_ID = "roleName";
    String FIELD_LOGIN_ID = "loginId";
    String FIELD_ALL_ROLE_ID = "roleIds";

    void setUserName(String var1);

    String getUserName();

    Long getUserId();

    <T> T getAttribute(String var1);

    Map<String, Object> getAttributeMap();

    Set<String> getAttributeNames();

    String getRoleName();

    String[] getAllRoleName();

    void setAllRoleName(String[] var1);

    void setUserId(Long var1);

    void setAttribute(String var1, Object var2);

    void setRoleName(String var1);
}

