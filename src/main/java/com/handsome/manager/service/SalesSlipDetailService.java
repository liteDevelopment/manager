package com.handsome.manager.service;

import com.handsome.manager.ao.SalesSlipDetailAO;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.SalesSlipDetail;
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
public interface SalesSlipDetailService extends IService<SalesSlipDetail> {
    List<SalesSlipDetailAO> list(int rows, int page);
    int count();
    ServiceResault query(String id);
    ServiceResault add(SalesSlipDetail salesSlipDetail);
    ServiceResault update(SalesSlipDetail salesSlipDetail);
    ServiceResault del(String id);
}
