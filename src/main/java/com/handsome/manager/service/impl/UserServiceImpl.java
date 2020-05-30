package com.handsome.manager.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.handsome.manager.ao.SelectAO;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.ao.UserAO;
import com.handsome.manager.mapper.AccountMapper;
import com.handsome.manager.mapper.RoleMapper;
import com.handsome.manager.mapper.UserMapper;
import com.handsome.manager.model.Account;
import com.handsome.manager.model.Role;
import com.handsome.manager.model.User;
import com.handsome.manager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public User getById(Long id) {
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
        userWrapper.eq("status", true);
        return userMapper.selectCount(userWrapper);
    }

    @Override
    public ServiceResault query(Long id) {
        UserAO user = userMapper.getUserById(id);
        return new ServiceResault(user);
    }

    @Override
    public ServiceResault add(UserAO userAO) {

        Wrapper<Account> validAccountWrapper = new EntityWrapper<Account>();
        validAccountWrapper.eq("account", userAO.getAccount());
        Integer num = accountMapper.selectCount(validAccountWrapper);
        if (num > 0) {
            return new ServiceResault(0, "登录账号已被使用！");
        }

        User user = new User();
        user.setName(userAO.getName());
        user.setPhone(userAO.getPhone());
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));//默认密码
        user.setRoleId(2L);//1管理员 2销售 新增只能新增销售
        user.setStatus(true);
        userMapper.insert(user);

        Account account = new Account();
        account.setAccount(userAO.getAccount());
        account.setType(1);
        account.setUserId(user.getId());
        accountMapper.insert(account);
        return new ServiceResault();
    }

    @Override
    public ServiceResault update(UserAO userAO) {

        Wrapper<Account> validAccountWrapper = new EntityWrapper<Account>();
        validAccountWrapper.eq("account", userAO.getAccount());
        validAccountWrapper.ne("user_id", userAO.getId());
        Integer num = accountMapper.selectCount(validAccountWrapper);
        if (num > 0) {
            return new ServiceResault(0, "登录账号已被使用！");
        }

        User user = userMapper.selectById(userAO.getId());
        Wrapper<User> userWrapper = new EntityWrapper<User>();
        userWrapper.eq("id", user.getId());
        User newUser = new User();
        newUser.setName(userAO.getName());
        newUser.setPhone(userAO.getPhone());
        userMapper.update(newUser, userWrapper);

        Wrapper<Account> accountWrapper = new EntityWrapper<Account>();
        accountWrapper.eq("user_id", user.getId());
        List<Account> accounts = accountMapper.selectList(accountWrapper);
        if (!CollectionUtils.isEmpty(accounts)) {
            Account account = accounts.get(0);
            Account newAccount = new Account();
            newAccount.setAccount(userAO.getAccount());
            accountMapper.update(newAccount, accountWrapper);
        }
        return new ServiceResault(userMapper.getUserById(userAO.getId()));
    }

    @Override
    public ServiceResault del(String id) {
        User user = userMapper.selectById(id);
        user.setStatus(false);
        userMapper.updateById(user);
        return new ServiceResault();
    }

    @Override
    public ServiceResault changePasswd(Long userId, String oldPass, String newPass) {
        User user = userMapper.selectById(userId);
        BCryptPasswordEncoder epe = new BCryptPasswordEncoder();
        if (!epe.matches(oldPass, user.getPassword())) {
            return new ServiceResault(0,"原密码不正确！");
        }
        String passswd = epe.encode(newPass);
        user.setPassword(passswd);
        userMapper.updateById(user);
        return new ServiceResault();
    }

    @Override
    public ServiceResault select() {
        List<SelectAO> select = userMapper.select();
        return new ServiceResault(select);
    }
}
