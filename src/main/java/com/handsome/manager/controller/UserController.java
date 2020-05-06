package com.handsome.manager.controller;


import com.handsome.manager.ao.DatatablesResult;
import com.handsome.manager.ao.TestAO;
import com.handsome.manager.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author handsome
 * @since 2020-05-02
 */
@Controller
@RequestMapping("/pc/user")
public class UserController {

    @RequestMapping(value = "/dataGrid")
    public ResponseEntity<DatatablesResult> list(User user,
                       @RequestParam(value = "draw") String draw,
                       @RequestParam(value = "start") String start,
                       @RequestParam(value = "length") String length) {
        int rows = Integer.parseInt(length);
        int page = (Integer.parseInt(start) / rows) + 1;
        user.setName("陈澄");
        user.setCode("111");
        user.setId(1L);
        List<User> users = new ArrayList<User>();
        users.add(user);
        DatatablesResult pageResult = new DatatablesResult<User>();
        pageResult.setData(users);
        pageResult.setDraw(1);
        pageResult.setRecordsTotal(20);
        pageResult.setRecordsFiltered(pageResult.getRecordsTotal());
        return ResponseEntity.ok(pageResult);
    }
}

