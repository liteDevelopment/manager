package com.handsome.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pc")
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("contentPage", "index");
        return "common";
    }

    @RequestMapping("/userManage")
    public String userManage(Model model) {
        model.addAttribute("contentPage", "user/userManage");
        return "common";
    }

    @RequestMapping("/userInfo")
    public String userInfo(Model model) {
        model.addAttribute("contentPage", "user/userInfo");
        return "common";
    }
}
