package com.handsome.manager.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/pc")
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
        // 获取用户信息
        org.springframework.security.core.userdetails.User myUserDetails= (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        model.addAttribute("userName", myUserDetails.getUsername());
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

    @RequestMapping("/customerManage")
    public String customerManage(Model model) {
        model.addAttribute("contentPage", "customer/customerManage");
        model.addAttribute("jsPaths", "/js/customer/customerManage.js");
        return "common";
    }


    @RequestMapping("/productManage")
    public String productManage(Model model) {
        model.addAttribute("contentPage", "product/productManage");
        model.addAttribute("jsPaths", "/js/product/productManage.js");
        return "common";
    }

}
