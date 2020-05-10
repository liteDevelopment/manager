package com.handsome.manager.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.handsome.manager.ao.UserAccountAO;
import com.handsome.manager.model.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author handsome
 * @since 2020-05-03
 */
public interface AccountMapper extends BaseMapper<Account> {
    @Select("SELECT * FROM account WHERE account = #{account}")
    Account selectByAccount(String account);

    UserAccountAO getUserAccountData(@Param("account") String account);
}
