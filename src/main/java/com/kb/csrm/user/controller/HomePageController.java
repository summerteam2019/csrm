/**
 * The type HomePageController.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class HomePageController {
    /**
     * 首页
     *
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
        model.addAttribute("name", "登陆");
        return "/登陆.html";
    }
}
