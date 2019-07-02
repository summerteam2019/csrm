/**
 * The type FieldErrorWithBean.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

import org.springframework.validation.FieldError;

public class FieldErrorWithBean extends FieldError {
    private Object targetBean;

    public FieldErrorWithBean(String objectName, String field, Object rejectedValue, boolean bindingFailure, String[] codes, Object[] arguments, String defaultMessage) {
        super(objectName, field, rejectedValue, bindingFailure, codes, arguments, defaultMessage);
    }

    public Object getTargetBean() {
        return this.targetBean;
    }

    public void setTargetBean(Object targetBean) {
        this.targetBean = targetBean;
    }
}
