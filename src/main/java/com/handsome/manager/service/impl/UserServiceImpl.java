package com.handsome.manager.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.mapper.UserMapper;
import com.handsome.manager.model.User;
import com.handsome.manager.service.UserService;
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
    public List<User> list(int rows, int page) {
//        Wrapper<User> userWrapper = new EntityWrapper<>();
//        () -> userWrapper.lambda().eq(User::getName, "小小");
//        userMapper.selectList(userWrapper);
        return null;
    }

    @Override
    public ServiceResault queryUser(String userId) {
        return null;
    }

    @Override
    public ServiceResault addUser(User user) {
        return null;
    }

    @Override
    public ServiceResault updateUser(User user) {
        return null;
    }

    @Override
    public ServiceResault delUser(String userId) {
        return null;
    }
}
