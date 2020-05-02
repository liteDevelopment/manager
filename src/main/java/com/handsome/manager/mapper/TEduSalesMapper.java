package com.handsome.manager.mapper;

import com.handsome.manager.model.TEduSales;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author handsome
 * @since 2020-05-01
 */
public interface TEduSalesMapper extends BaseMapper<TEduSales> {

    TEduSales getCustomerData(@Param("id") String id);
}
