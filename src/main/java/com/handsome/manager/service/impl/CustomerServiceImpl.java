package com.handsome.manager.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.handsome.manager.ao.SelectAO;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.Customer;
import com.handsome.manager.mapper.CustomerMapper;
import com.handsome.manager.service.CustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> list(int rows, int page) {
        Wrapper<Customer> customerWrapper = new EntityWrapper<Customer>();
        customerWrapper.eq("status", true);
        Page p = new Page(page, rows);
        List<Customer> customers = customerMapper.selectPage(p, customerWrapper);
        return customers;
    }

    @Override
    public int count() {
        Wrapper<Customer> customerWrapper = new EntityWrapper<Customer>();
        customerWrapper.eq("status", true);
        return customerMapper.selectCount(customerWrapper);
    }

    @Override
    public ServiceResault query(String id) {
        return null;
    }

    @Override
    public ServiceResault add(Customer customer) {
        customerMapper.insert(customer);
        return new ServiceResault();
    }

    @Override
    public ServiceResault update(Customer customer) {
        Wrapper<Customer> customerWrapper = new EntityWrapper<Customer>();
        customerWrapper.eq("id", customer.getId());
        customerMapper.update(customer, customerWrapper);
        return new ServiceResault();
    }

    @Override
    public ServiceResault del(String id) {
        Wrapper<Customer> customerWrapper = new EntityWrapper<Customer>();
        customerWrapper.eq("id", id);
        Customer customer = new Customer();
        customer.setStatus(false);
        try {
            customerMapper.update(customer, customerWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ServiceResault();
    }

    @Override
    public ServiceResault select() {
        List<SelectAO> select = customerMapper.select();
        return new ServiceResault(select);
    }
}
