/**
 * The type DefaultConfiguration.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

import org.springframework.stereotype.Component;

@Component
public class DefaultConfiguration {
    private String pageLogin = "/login.html";
    private String page404 = "/404.html";
    private String page403 = "/403.html";
    private String page500 = "/500.html";
    private String defaultViewPath = "";

    public DefaultConfiguration() {
    }

    public String getDefaultViewPath() {
        return this.defaultViewPath;
    }

    public void setDefaultViewPath(String defaultViewPath) {
        this.defaultViewPath = defaultViewPath;
    }

    public String getPage404() {
        return this.page404;
    }

    public void setPage404(String page404) {
        this.page404 = page404;
    }

    public String getPage403() {
        return this.page403;
    }

    public void setPage403(String page403) {
        this.page403 = page403;
    }

    public String getPage500() {
        return this.page500;
    }

    public void setPage500(String page500) {
        this.page500 = page500;
    }

    public String getPageLogin() {
        return this.pageLogin;
    }

    public void setPageLogin(String pageLogin) {
        this.pageLogin = pageLogin;
    }
}
