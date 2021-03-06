package com.handsome.manager.controller;


import com.handsome.manager.ao.DatatablesResult;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.ao.TestAO;
import com.handsome.manager.ao.UserAO;
import com.handsome.manager.model.User;
import com.handsome.manager.service.UserService;
import com.handsome.manager.system.AuthHeaper;
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
        List<UserAO> users = userService.list(rows, page);
        DatatablesResult pageResult = new DatatablesResult<UserAO>();
        pageResult.setData(users);
        pageResult.setDraw(draw);
        pageResult.setRecordsTotal(userService.count());
        pageResult.setRecordsFiltered(pageResult.getRecordsTotal());
        return ResponseEntity.ok(pageResult);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResault> delete(@RequestParam(value = "id") String id) {
        userService.del(id);
        return ResponseEntity.ok(new ServiceResault());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<ServiceResault> save(UserAO user) {
        ServiceResault sr;
        if (StringUtils.isEmpty(user.getId())) {
            sr = userService.add(user);
        } else {
            sr = userService.update(user);
        }
        return ResponseEntity.ok(sr);
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public ResponseEntity<ServiceResault> updateUserInfo(UserAO user) {
        ServiceResault sr = userService.update(user);
        return ResponseEntity.ok(sr);
    }

    @RequestMapping(value = "/changePasswd", method = RequestMethod.POST)
    public ResponseEntity<ServiceResault> changePasswd(String oldPass, String newPass) {
        ServiceResault sr = userService.changePasswd(AuthHeaper.getCurrentUser().getId(), oldPass, newPass);
        return ResponseEntity.ok(sr);
    }

    @RequestMapping(value = "/select")
    public ResponseEntity<ServiceResault> select() {
        return ResponseEntity.ok(userService.select());
    }
}

