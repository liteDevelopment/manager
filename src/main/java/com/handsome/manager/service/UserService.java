package com.handsome.manager.service;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.User;
import com.baomidou.mybatisplus.service.IService;

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

    ServiceResault queryUser(String userId);
    ServiceResault addUser(User user);
    ServiceResault updateUser(User user);
    ServiceResault delUser(String userId);
}
