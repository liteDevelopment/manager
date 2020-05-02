package com.handsome.manager.service;

import com.handsome.manager.model.TEduSales;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author handsome
 * @since 2020-05-01
 */
public interface TEduSalesService extends IService<TEduSales> {

    TEduSales getById(String id);
}
