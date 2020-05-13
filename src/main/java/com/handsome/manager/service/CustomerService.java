package com.handsome.manager.service;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.Customer;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author handsome
 * @since 2020-05-11
 */
public interface CustomerService extends IService<Customer> {


    ServiceResault queryCustomer(String userId);
    ServiceResault addCustomer(Customer customer);
    ServiceResault updateCustomer(Customer customer);
    ServiceResault delCustomer(String customerId);
}
