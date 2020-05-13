package com.handsome.manager.service;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.Product;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author handsome
 * @since 2020-05-11
 */
public interface ProductService extends IService<Product> {
    ServiceResault queryProduct(String userId);
    ServiceResault addProduct(Product product);
    ServiceResault updateProduct(Product product);
    ServiceResault delProduct(String customerId);
}
