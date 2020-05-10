package com.handsome.manager.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.handsome.manager.model.UserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author handsome
 * @since 2020-05-03
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
    @Select("SELECT * FROM user_role WHERE user_id = #{userId}")
    List<UserRole> listByUserId(String userId);
}
