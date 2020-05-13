package com.handsome.manager.service;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.SalesSlip;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author handsome
 * @since 2020-05-13
 */
public interface SalesSlipService extends IService<SalesSlip> {
    ServiceResault querySalesSlip(String userId);
    ServiceResault addSalesSlip(SalesSlip product);
    ServiceResault updateSalesSlip(SalesSlip product);
    ServiceResault delSalesSlip(String customerId);
}
