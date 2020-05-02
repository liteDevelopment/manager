package com.handsome.manager.service.impl;

import com.handsome.manager.model.TEduSales;
import com.handsome.manager.mapper.TEduSalesMapper;
import com.handsome.manager.service.TEduSalesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author handsome
 * @since 2020-05-01
 */
@Service
public class TEduSalesServiceImpl extends ServiceImpl<TEduSalesMapper, TEduSales> implements TEduSalesService {

    @Resource
    private TEduSalesMapper eduSalesMapper;

    @Override
    public TEduSales getById(String id) {
        return eduSalesMapper.selectById(id);
    }
}
