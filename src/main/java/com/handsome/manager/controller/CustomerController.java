package com.handsome.manager.controller;


import com.handsome.manager.ao.DatatablesResult;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.Customer;
import com.handsome.manager.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author handsome
 * @since 2020-05-11
 */
@Controller
@RequestMapping("/pc/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping(value = "/dataGrid")
    public ResponseEntity<DatatablesResult> list(Customer customer,
                                                 @RequestParam(value = "draw") int draw,
                                                 @RequestParam(value = "start") String start,
                                                 @RequestParam(value = "length") String length) {
        int rows = Integer.parseInt(length);
        int page = (Integer.parseInt(start) / rows) + 1;
        List<Customer> users = customerService.list(rows, page);
        DatatablesResult pageResult = new DatatablesResult<Customer>();
        pageResult.setData(users);
        pageResult.setDraw(draw);
        pageResult.setRecordsTotal(customerService.count());
        pageResult.setRecordsFiltered(pageResult.getRecordsTotal());
        return ResponseEntity.ok(pageResult);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResault> delete(@RequestParam(value = "id") String id) {
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        customerService.del(id);
        return ResponseEntity.ok(new ServiceResault());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<ServiceResault> save(Customer user) {
        if (StringUtils.isEmpty(user.getId())) {
            customerService.add(user);
        } else {
            customerService.add(user);
        }
        return ResponseEntity.ok(new ServiceResault());
    }

    @RequestMapping(value = "/select")
    public ResponseEntity<ServiceResault> select() {
        return ResponseEntity.ok(customerService.select());
    }
}

