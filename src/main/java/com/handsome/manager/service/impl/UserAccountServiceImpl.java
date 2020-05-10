package com.handsome.manager.service.impl;

import com.handsome.manager.model.UserAccount;
import com.handsome.manager.mapper.UserAccountMapper;
import com.handsome.manager.service.UserAccountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author handsome
 * @since 2020-05-03
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

}
