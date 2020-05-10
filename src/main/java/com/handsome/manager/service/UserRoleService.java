package com.handsome.manager.service;

import com.baomidou.mybatisplus.service.IService;
import com.handsome.manager.model.UserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author handsome
 * @since 2020-05-03
 */
public interface UserRoleService extends IService<UserRole> {
    @Select("SELECT * FROM user_role WHERE user_id = #{userId}")
    List<UserRole> listByUserId(String userId);
}
