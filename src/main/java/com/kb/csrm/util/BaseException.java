/**
 * The type BaseException.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

public abstract class BaseException extends Exception implements IBaseException{
    private static final long serialVersionUID = 1L;
    private String code;
    private String descriptionKey;
    private Object[] parameters;

    protected BaseException(String code, String descriptionKey, Object[] parameters) {
        super(descriptionKey);
        this.code = code;
        this.descriptionKey = descriptionKey;
        this.parameters = parameters;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDescriptionKey() {
        return this.descriptionKey;
    }

    @Override
    public Object[] getParameters() {
        return this.parameters;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void setDescriptionKey(String descriptionKey) {
        this.descriptionKey = descriptionKey;
    }

    @Override
    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
