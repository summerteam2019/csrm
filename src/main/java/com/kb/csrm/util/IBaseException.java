/**
 * The type IBaseException.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

public interface IBaseException {
    String getCode();

    String getDescriptionKey();

    Object[] getParameters();

    void setCode(String var1);

    void setDescriptionKey(String var1);

    void setParameters(Object[] var1);
}
