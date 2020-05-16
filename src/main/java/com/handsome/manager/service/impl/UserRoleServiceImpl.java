package com.handsome.manager.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.handsome.manager.mapper.UserRoleMapper;
import com.handsome.manager.model.UserRole;
import com.handsome.manager.service.UserRoleService;
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
 * @since 2020-05-03
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> listByUserId(String userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
