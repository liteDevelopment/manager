package com.handsome.manager.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.handsome.manager.ao.SelectAO;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.ao.UserAO;
import com.handsome.manager.mapper.UserMapper;
import com.handsome.manager.model.User;
import com.handsome.manager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author handsome
 * @since 2020-05-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User getById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public List<UserAO> list(int rows, int page) {
        Page p = new Page(page, rows);
        List<UserAO> users = userMapper.getUsers(p.getOffset(), p.getSize());
        return users;
    }

    @Override
    public int count() {
        Wrapper<User> userWrapper = new EntityWrapper<User>();
        //salesSlipWrapper.eq("status", true);
        return userMapper.selectCount(userWrapper);
    }

    @Override
    public ServiceResault query(String id) {
        return null;
    }

    @Override
    public ServiceResault add(UserAO user) {
        return null;
    }

    @Override
    public ServiceResault update(UserAO user) {
        return null;
    }

    @Override
    public ServiceResault del(String id) {
        return null;
    }

    @Override
    public ServiceResault select() {
        List<SelectAO> select = userMapper.select();
        return new ServiceResault(select);
    }
}
