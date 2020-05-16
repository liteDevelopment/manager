package com.handsome.manager.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.Product;
import com.handsome.manager.mapper.ProductMapper;
import com.handsome.manager.service.ProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> list(int rows, int page) {
        Wrapper<Product> productWrapper = new EntityWrapper<Product>();
        productWrapper.eq("status", true);
        Page p = new Page(page, rows);
        List<Product> products = productMapper.selectPage(p, productWrapper);
        return products;
    }

    @Override
    public int count() {
        Wrapper<Product> productWrapper = new EntityWrapper<Product>();
        productWrapper.eq("status", true);
        return productMapper.selectCount(productWrapper);
    }

    @Override
    public ServiceResault query(String productId) {
        return null;
    }

    @Override
    public ServiceResault add(Product product) {
        productMapper.insert(product);
        return new ServiceResault();
    }

    @Override
    public ServiceResault update(Product product) {
        Wrapper<Product> productWrapper = new EntityWrapper<Product>();
        productWrapper.eq("id", product.getId());
        productMapper.update(product, productWrapper);
        return new ServiceResault();
    }

    @Override
    public ServiceResault del(String productId) {
        Wrapper<Product> productWrapper = new EntityWrapper<Product>();
        productWrapper.eq("id", productId);
        Product product = new Product();
        product.setStatus(false);
        try {
            productMapper.update(product, productWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ServiceResault();
    }
}
