package com.handsome.manager.service.impl;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.SalesSlip;
import com.handsome.manager.mapper.SalesSlipMapper;
import com.handsome.manager.service.SalesSlipService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author handsome
 * @since 2020-05-13
 */
@Service
public class SalesSlipServiceImpl extends ServiceImpl<SalesSlipMapper, SalesSlip> implements SalesSlipService {

    @Override
    public List<SalesSlip> list(int rows, int page) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public ServiceResault query(String id) {
        return null;
    }

    @Override
    public ServiceResault add(SalesSlip product) {
        return null;
    }

    @Override
    public ServiceResault update(SalesSlip product) {
        return null;
    }

    @Override
    public ServiceResault del(String id) {
        return null;
    }
}
