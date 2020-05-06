package com.handsome.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/pc")
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("contentPage", "index");
        model.addAttribute("jsPaths", new ArrayList<String>());
        return "common";
    }

    @RequestMapping("/userManage")
    public String userManage(Model model) {
        model.addAttribute("contentPage", "user/userManage");
        model.addAttribute("jsPaths", "/js/user/userManage.js");
        return "common";
    }

    @RequestMapping("/userInfo")
    public String userInfo(Model model) {
        model.addAttribute("contentPage", "user/userInfo");
        model.addAttribute("jsPaths", new ArrayList<String>());
        return "common";
    }
}
