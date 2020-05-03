package com.handsome.manager.controller;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.ao.TestAO;
import com.handsome.manager.model.User;
import com.handsome.manager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Object logout() {
        return new ServiceResault(1, "登出成功");
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public Object doLogin(String loginName, String passWord) {
        return new ServiceResault(1, "登录成功");
    }
}
