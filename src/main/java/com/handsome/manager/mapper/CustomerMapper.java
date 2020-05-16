package com.handsome.manager.mapper;

import com.handsome.manager.ao.SelectAO;
import com.handsome.manager.model.Customer;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author handsome
 * @since 2020-05-13
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    List<SelectAO> select();

}
