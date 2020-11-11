package com.watchstore.vv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAllProducts() {
        return "products";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getDetailProduct(@RequestParam(value = "id") String id) {
        return "product";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactUs() {
        return "contact";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String blog() {
        return "blog";
    }

    @RequestMapping(value = "/forgetpassword", method = RequestMethod.GET)
    public String forgetPassword() {
        return "forgetpassword";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkOut() {
        return "checkout";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart() {
        return "cart";
    }
}
