package com.handsome.manager.mapper;

import com.handsome.manager.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author handsome
 * @since 2020-05-02
 */
public interface UserMapper extends BaseMapper<User> {
    User getCustomerData(@Param("id") String id);
}
