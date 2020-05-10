package com.handsome.manager.service;

import com.baomidou.mybatisplus.service.IService;
import com.handsome.manager.model.Role;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author handsome
 * @since 2020-05-03
 */
public interface RoleService extends IService<Role> {
    Role selectById(String id);
}
