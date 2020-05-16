package com.handsome.manager.service;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.Customer;
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
public interface CustomerService extends IService<Customer> {

    List<Customer> list(int rows, int page);
    int count();
    ServiceResault query(String id);
    ServiceResault add(Customer customer);
    ServiceResault update(Customer customer);
    ServiceResault del(String id);
    ServiceResault select();
}
