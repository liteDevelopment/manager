package com.handsome.manager.service;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.ao.UserAO;
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
    User getById(Long id);

    User selectByName(String name);

    List<UserAO> list(int rows, int page);
    int count();
    ServiceResault query(Long id);
    ServiceResault add(UserAO user);
    ServiceResault update(UserAO user);
    ServiceResault del(String id);
    ServiceResault changePasswd(Long userId, String oldPass, String newPass);
    ServiceResault select();
}
