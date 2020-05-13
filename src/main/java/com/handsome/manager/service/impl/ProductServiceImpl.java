package com.handsome.manager.service.impl;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.Product;
import com.handsome.manager.mapper.ProductMapper;
import com.handsome.manager.service.ProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author handsome
 * @since 2020-05-11
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public ServiceResault queryProduct(String userId) {
        return null;
    }

    @Override
    public ServiceResault addProduct(Product product) {
        return null;
    }

    @Override
    public ServiceResault updateProduct(Product product) {
        return null;
    }

    @Override
    public ServiceResault delProduct(String customerId) {
        return null;
    }
}
