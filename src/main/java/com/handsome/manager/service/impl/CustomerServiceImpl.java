package com.handsome.manager.service.impl;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.Customer;
import com.handsome.manager.mapper.CustomerMapper;
import com.handsome.manager.service.CustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    public ServiceResault query(String id) {
        return null;
    }

    @Override
    public ServiceResault add(Customer customer) {
        return null;
    }

    @Override
    public ServiceResault update(Customer customer) {
        return null;
    }

    @Override
    public ServiceResault del(String id) {
        return null;
    }
}
