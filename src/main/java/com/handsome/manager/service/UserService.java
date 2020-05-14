package com.handsome.manager.service;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.User;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author handsome
 * @since 2020-05-02
 */
public interface UserService extends IService<User> {
    User getById(String id);

    User selectByName(String name);

    List<User> list(int rows, int page);
    ServiceResault query(String id);
    ServiceResault add(User user);
    ServiceResault update(User user);
    ServiceResault del(String id);
}
