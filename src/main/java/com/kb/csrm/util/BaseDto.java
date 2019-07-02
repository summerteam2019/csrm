/**
 * The type BaseDto.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Transient;

public class BaseDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String _token;

    public String get_token() {
        return this._token;
    }

    public void set_token(String _token) {
        this._token = _token;
    }
}
