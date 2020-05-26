package com.handsome.manager.controller;

import com.handsome.manager.ao.ServiceResault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/salesSlip")
    public String salesSlip(Model model) {
        model.addAttribute("contentPage", "salesslip/salesSlip");
        model.addAttribute("jsPaths", "/js/salesslip/salesSlip.js");
        return "common";
    }

    @RequestMapping("/reportSaleDetails")
    public String reportSaleDetails(Model model) {
        model.addAttribute("contentPage", "report/reportSaleDetails");
        model.addAttribute("jsPaths", "/js/report/reportSaleDetails.js");
        return "common";
    }

    @RequestMapping("/noPermission")
    public String permission(Model model) {
        model.addAttribute("msg", "无权限");
        model.addAttribute("contentPage", "error");
        model.addAttribute("jsPaths", new ArrayList<String>());
        return "common";
    }

    @RequestMapping(value = "/heatbeat", method = RequestMethod.GET)
    public ResponseEntity<ServiceResault> heatbeat() {
        return ResponseEntity.ok(new ServiceResault());
    }
}
