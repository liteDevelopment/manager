package com.handsome.manager.controller;


import com.handsome.manager.ao.DatatablesResult;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.ao.TestAO;
import com.handsome.manager.model.User;
import com.handsome.manager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @Resource
    private UserService userService;

    @RequestMapping(value = "/dataGrid")
    public ResponseEntity<DatatablesResult> list(User user,
                       @RequestParam(value = "draw") int draw,
                       @RequestParam(value = "start") String start,
                       @RequestParam(value = "length") String length) {
        int rows = Integer.parseInt(length);
        int page = (Integer.parseInt(start) / rows) + 1;
        List<User> users = userService.list(rows, page);
        /*if (1==page) {
            User user1 = new User();
            user1.setName("陈澄1");
            user1.setPhone("111");
            user1.setId(1);
            users.add(user1);
            User user2 = new User();
            user2.setName("陈澄2");
            user2.setPhone("111");
            user2.setId(1);
            users.add(user2);
            User user3 = new User();
            user3.setName("陈澄3");
            user3.setPhone("111");
            user3.setId(1);
            users.add(user3);
            User user4 = new User();
            user4.setName("陈澄4");
            user4.setPhone("111");
            user4.setId(1);
            users.add(user4);
            User user5 = new User();
            user5.setName("陈澄5");
            user5.setPhone("111");
            user5.setId(1);
            users.add(user5);
            User user6 = new User();
            user6.setName("陈澄6");
            user6.setPhone("111");
            user6.setId(1);
            users.add(user6);
            User user7 = new User();
            user7.setName("陈澄7");
            user7.setPhone("111");
            user7.setId(1);
            users.add(user7);
            User user8 = new User();
            user8.setName("陈澄8");
            user8.setPhone("111");
            user8.setId(1);
            users.add(user8);
            User user9 = new User();
            user9.setName("陈澄9");
            user9.setPhone("111");
            user9.setId(1);
            users.add(user9);
            User user10 = new User();
            user10.setName("陈澄10");
            user10.setPhone("111");
            user10.setId(1);
            users.add(user10);
        } else if (2==page) {
            User user11 = new User();
            user11.setName("陈澄11");
            user11.setPhone("111");
            user11.setId(1);
            users.add(user11);
            User user12 = new User();
            user12.setName("陈澄12");
            user12.setPhone("111");
            user12.setId(1);
            users.add(user12);
            User user13 = new User();
            user13.setName("陈澄13");
            user13.setPhone("111");
            user13.setId(1);
            users.add(user13);
            User user14 = new User();
            user14.setName("陈澄14");
            user14.setPhone("111");
            user14.setId(1);
            users.add(user14);
            User user15 = new User();
            user15.setName("陈澄15");
            user15.setPhone("111");
            user15.setId(1);
            users.add(user15);
        }*/
        DatatablesResult pageResult = new DatatablesResult<User>();
        pageResult.setData(users);
        pageResult.setDraw(draw);
        pageResult.setRecordsTotal(20);
        pageResult.setRecordsFiltered(pageResult.getRecordsTotal());
        return ResponseEntity.ok(pageResult);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<ServiceResault> delete(@RequestParam(value = "id") String id) {
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        userService.del(id);
        return ResponseEntity.ok(new ServiceResault());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<ServiceResault> save(User user) {
        if (StringUtils.isEmpty(user.getId())) {
            userService.add(user);
        } else {
            userService.update(user);
        }
        return ResponseEntity.ok(new ServiceResault());
    }
}

