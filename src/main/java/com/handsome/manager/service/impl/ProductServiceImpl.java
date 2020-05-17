package com.handsome.manager.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.handsome.manager.ao.SelectAO;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.Product;
import com.handsome.manager.mapper.ProductMapper;
import com.handsome.manager.service.ProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

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

    @Override
    public ServiceResault select() {
        List<SelectAO> select = productMapper.select();
        return new ServiceResault(select);
    }
}
