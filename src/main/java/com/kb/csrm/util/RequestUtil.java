/**
 * The type RequestUtil.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public final class RequestUtil {
    public static final String X_REQUESTED_WIDTH = "X-Requested-With";
    public static final String XML_HTTP_REQUEST = "XMLHttpRequest";

    private RequestUtil() {
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String xr = request.getHeader("X-Requested-With");
        return xr != null && "XMLHttpRequest".equalsIgnoreCase(xr);
    }

    public static boolean isAPIRequest(HttpServletRequest request) {
        return request.getRequestURI().contains("/api/");
    }

    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Cookie[] var3 = cookies;
            int var4 = cookies.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Cookie cookie = var3[var5];
                String cookieName = cookie.getName();
                if (cookieName.equals(name)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }
}
