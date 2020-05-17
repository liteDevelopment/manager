package com.handsome.manager.mapper;

import com.handsome.manager.ao.SelectAO;
import com.handsome.manager.model.Product;
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
public interface ProductMapper extends BaseMapper<Product> {

    List<SelectAO> select();
}
