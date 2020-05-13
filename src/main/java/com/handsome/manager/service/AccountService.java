package com.handsome.manager.service;

import com.baomidou.mybatisplus.service.IService;
import com.handsome.manager.ao.UserAccountAO;
import com.handsome.manager.model.Account;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author handsome
 * @since 2020-05-03
 */
public interface AccountService extends IService<Account> {
    UserAccountAO getUserAccountData(String account);
}
