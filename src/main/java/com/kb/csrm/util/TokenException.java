/**
 * The type TokenException.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

public class TokenException extends BaseException {
    private static final long serialVersionUID = -4610975985890969248L;
    public static final String CODE = "TOKEN_FAILURE";
    public static final String MSG_NOT_EXISTS = "msg.error.token_not_exists";
    public static final String MSG_CHECK_FAILED = "msg.error.token_check_failed";
    private BaseDto dto;

    public TokenException(BaseDto dto) {
        this("msg.error.token_check_failed", dto);
    }

    public TokenException(String descriptionKey, BaseDto dto) {
        super("TOKEN_FAILURE", descriptionKey, (Object[])null);
        this.dto = dto;
    }

    public <T> T getDto() {
        return (T) this.dto;
    }
}