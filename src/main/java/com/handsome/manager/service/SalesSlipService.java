package com.handsome.manager.service;

import com.handsome.manager.ao.SalesSlipAO;
import com.handsome.manager.ao.SalesSlipDetailAO;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.SalesSlip;
import com.baomidou.mybatisplus.service.IService;
import com.handsome.manager.model.SalesSlipDetail;

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
    List<SalesSlipAO> list(int rows, int page);
    int count();
    ServiceResault query(String id);
    ServiceResault add(SalesSlip salesSlip);
    ServiceResault update(SalesSlip salesSlip);
    ServiceResault del(String id);
}
