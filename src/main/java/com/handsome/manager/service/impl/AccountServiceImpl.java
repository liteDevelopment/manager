package com.handsome.manager.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.handsome.manager.ao.UserAccountAO;
import com.handsome.manager.mapper.AccountMapper;
import com.handsome.manager.model.Account;
import com.handsome.manager.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author handsome
 * @since 2020-05-03
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public UserAccountAO getUserAccountData(String account) {
        return accountMapper.getUserAccountData(account);
    }
}
