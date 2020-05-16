package com.handsome.manager.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.handsome.manager.mapper.RoleMapper;
import com.handsome.manager.model.Role;
import com.handsome.manager.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Role selectById(String id) {
        return roleMapper.selectById(id);
    }
}
