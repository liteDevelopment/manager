package com.handsome.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/userManage")
    public String userManage() {
        return "user/userManage";
    }

    @RequestMapping("/userInfo")
    public String userInfo() {
        return "user/userInfo";
    }
}
