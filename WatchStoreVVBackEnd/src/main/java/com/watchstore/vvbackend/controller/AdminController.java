package com.watchstore.vvbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping(value = "/admin")
    public String admin() {
        return "index";
    }

    @RequestMapping(value = "/tables")
    public String adminTables() {
        return "tables";
    }

    @RequestMapping(value = "/404")
    public String notFound() {
        return "404";
    }

    @RequestMapping(value = "/blank")
    public String blank() {
        return "blank";
    }

    @RequestMapping(value = "/buttons")
    public String buttons() {
        return "buttons";
    }

    @RequestMapping(value = "/cards")
    public String cards() {
        return "cards";
    }

    @RequestMapping(value = "/charts")
    public String charts() {
        return "charts";
    }

    @RequestMapping(value = "/forgot-password")
    public String forgotPassword() {
        return "forgot-password";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/utilities-animation")
    public String utilitiesAnimation() {
        return "utilities-animation";
    }

    @RequestMapping(value = "/utilities-border")
    public String utilitiesBorder() {
        return "utilities-border";
    }

    @RequestMapping(value = "/utilities-color")
    public String utilitiesColor() {
        return "utilities-color";
    }

    @RequestMapping(value = "/utilities-other")
    public String utilitiesOther() {
        return "utilities-other";
    }
}
