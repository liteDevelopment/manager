package com.handsome.manager.controller;

import com.handsome.manager.ao.TestAO;
import com.handsome.manager.model.User;
import com.handsome.manager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("msg", "欢迎！");
        return "hello";
    }

    @RequestMapping("/getData")
    @ResponseBody
    public Object getData(String id) {
        TestAO test = new TestAO();
        test.setName("lijia");
        test.setAge(27);
        test.setAddress("北京");
        List<User> users = userService.selectList(null);
        User user = userService.getById(id);
        return user;
    }
}
