package com.handsome.manager.service;

import com.handsome.manager.ao.SelectAO;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.Product;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author handsome
 * @since 2020-05-11
 */
public interface ProductService extends IService<Product> {
    List<Product> list(int rows, int page);
    int count();
    ServiceResault query(String productId);
    ServiceResault add(Product product);
    ServiceResault update(Product product);
    ServiceResault del(String productId);
    ServiceResault select();
}
