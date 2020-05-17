package com.handsome.manager.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.handsome.manager.ao.SelectAO;
import com.handsome.manager.ao.UserAO;
import com.handsome.manager.model.User;
import org.apache.ibatis.annotations.Param;
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
public interface UserMapper extends BaseMapper<User> {
    User getCustomerData(@Param("id") String id);

    @Select("SELECT * FROM user WHERE name = #{name}")
    User selectByName(String name);

    List<SelectAO> select();

    List<UserAO> getUsers(@Param("begin") int begin, @Param("length") int length);
}
