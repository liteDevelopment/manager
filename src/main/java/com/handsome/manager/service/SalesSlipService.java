package com.handsome.manager.service;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.SalesSlip;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author handsome
 * @since 2020-05-13
 */
public interface SalesSlipService extends IService<SalesSlip> {
    List<SalesSlip> list(int rows, int page);
    int count();
    ServiceResault query(String id);
    ServiceResault add(SalesSlip product);
    ServiceResault update(SalesSlip product);
    ServiceResault del(String id);
}
