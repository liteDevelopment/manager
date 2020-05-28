package com.handsome.manager.controller;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.service.SysConfigService;
import com.handsome.manager.system.AuthHeaper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pc")
public class IndexController {

    @Resource
    private SysConfigService sysConfigService;

    @RequestMapping("/index")
    public String index(Model model) {
        // 获取用户信息
        model.addAttribute("contentPage", "index");
        model.addAttribute("jsPaths", new ArrayList<String>());
        model.addAttribute("authList", AuthHeaper.getAuthList());
        model.addAttribute("userName", AuthHeaper.getCurrentUser().getName());
        return "common";
    }

    @RequestMapping("/sysConfig")
    public String sysConfig(Model model) {
        model.addAttribute("contentPage", "config/sysConfig");
        model.addAttribute("jsPaths", "/js/config/sysConfig.js");
        model.addAttribute("sysConfigs", sysConfigService.getList().getData());
        model.addAttribute("authList", AuthHeaper.getAuthList());
        model.addAttribute("userName", AuthHeaper.getCurrentUser().getName());
        return "common";
    }

    @RequestMapping("/userManage")
    public String userManage(Model model) {
        model.addAttribute("contentPage", "user/userManage");
        model.addAttribute("jsPaths", "/js/user/userManage.js");
        model.addAttribute("authList", AuthHeaper.getAuthList());
        model.addAttribute("userName", AuthHeaper.getCurrentUser().getName());
        return "common";
    }

    @RequestMapping("/userInfo")
    public String userInfo(Model model) {
        model.addAttribute("contentPage", "user/userInfo");
        model.addAttribute("jsPaths", new ArrayList<String>());
        model.addAttribute("authList", AuthHeaper.getAuthList());
        model.addAttribute("userName", AuthHeaper.getCurrentUser().getName());
        return "common";
    }

    @RequestMapping("/customerManage")
    public String customerManage(Model model) {
        model.addAttribute("contentPage", "customer/customerManage");
        model.addAttribute("jsPaths", "/js/customer/customerManage.js");
        model.addAttribute("authList", AuthHeaper.getAuthList());
        model.addAttribute("userName", AuthHeaper.getCurrentUser().getName());
        return "common";
    }


    @RequestMapping("/productManage")
    public String productManage(Model model) {
        model.addAttribute("contentPage", "product/productManage");
        model.addAttribute("jsPaths", "/js/product/productManage.js");
        model.addAttribute("authList", AuthHeaper.getAuthList());
        model.addAttribute("userName", AuthHeaper.getCurrentUser().getName());
        return "common";
    }

    @RequestMapping("/salesSlip")
    public String salesSlip(Model model) {
        model.addAttribute("contentPage", "salesslip/salesSlip");
        model.addAttribute("jsPaths", "/js/salesslip/salesSlip.js");
        model.addAttribute("authList", AuthHeaper.getAuthList());
        model.addAttribute("userName", AuthHeaper.getCurrentUser().getName());
        return "common";
    }

    @RequestMapping("/reportSaleDetails")
    public String reportSaleDetails(Model model) {
        model.addAttribute("contentPage", "report/reportSaleDetails");
        model.addAttribute("jsPaths", "/js/report/reportSaleDetails.js");
        model.addAttribute("authList", AuthHeaper.getAuthList());
        model.addAttribute("userId", AuthHeaper.getCurrentUser().getId());
        model.addAttribute("userName", AuthHeaper.getCurrentUser().getName());
        return "common";
    }

    @RequestMapping("/noPermission")
    public String permission(Model model) {
        model.addAttribute("msg", "无权限");
        model.addAttribute("contentPage", "error");
        model.addAttribute("jsPaths", new ArrayList<String>());
        model.addAttribute("authList", AuthHeaper.getAuthList());
        model.addAttribute("userName", AuthHeaper.getCurrentUser().getName());
        return "common";
    }

    @RequestMapping(value = "/heatbeat", method = RequestMethod.GET)
    public ResponseEntity<ServiceResault> heatbeat() {
        return ResponseEntity.ok(new ServiceResault());
    }
}
