package com.handsome.manager.controller;

import com.handsome.manager.ao.TestAO;
import com.handsome.manager.model.TEduSales;
import com.handsome.manager.service.TEduSalesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TEduSalesService eduSalesService;

    @RequestMapping("/getData")
    @ResponseBody
    public Object getData(String id) {
        TestAO test = new TestAO();
        test.setName("lijia");
        test.setAge(27);
        test.setAddress("北京");
        List< TEduSales > users = eduSalesService.selectList(null);
        TEduSales user = eduSalesService.getById(id);
        return user;
    }
}
