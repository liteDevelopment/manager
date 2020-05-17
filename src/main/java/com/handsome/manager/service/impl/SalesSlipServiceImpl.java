package com.handsome.manager.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.handsome.manager.ao.SalesSlipAO;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.SalesSlip;
import com.handsome.manager.mapper.SalesSlipMapper;
import com.handsome.manager.service.SalesSlipService;
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
 * @since 2020-05-13
 */
@Service
public class SalesSlipServiceImpl extends ServiceImpl<SalesSlipMapper, SalesSlip> implements SalesSlipService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesSlipServiceImpl.class);

    @Resource
    private SalesSlipMapper salesSlipMapper;

    @Override
    public List<SalesSlipAO> list(int rows, int page) {
        Page p = new Page(page, rows);
//        Wrapper<SalesSlip> salesSlipWrapper = new EntityWrapper<SalesSlip>();
//        salesSlipWrapper.eq("status", true);
//        List<SalesSlip> salesSlips = salesSlipMapper.selectPage(p, salesSlipWrapper);
        List<SalesSlipAO> salesSlips = salesSlipMapper.getSalesSlips(p.getOffset(), p.getSize());
        return salesSlips;
    }

    @Override
    public int count() {
        Wrapper<SalesSlip> salesSlipWrapper = new EntityWrapper<SalesSlip>();
        salesSlipWrapper.eq("status", true);
        return salesSlipMapper.selectCount(salesSlipWrapper);
    }

    @Override
    public ServiceResault query(String id) {
        SalesSlip salesSlip = salesSlipMapper.selectById(id);
        return new ServiceResault(salesSlip);
    }

    @Override
    public ServiceResault add(SalesSlip salesSlip) {
        salesSlipMapper.insert(salesSlip);
        return new ServiceResault();
    }

    @Override
    public ServiceResault update(SalesSlip salesSlip) {
        Wrapper<SalesSlip> productWrapper = new EntityWrapper<SalesSlip>();
        productWrapper.eq("id", salesSlip.getId());
        salesSlipMapper.update(salesSlip, productWrapper);
        return new ServiceResault();
    }

    @Override
    public ServiceResault del(String id) {
        Wrapper<SalesSlip> salesSlipWrapper = new EntityWrapper<SalesSlip>();
        salesSlipWrapper.eq("id", id);
        SalesSlip salesSlip = new SalesSlip();
        salesSlip.setStatus(false);
        try {
            salesSlipMapper.update(salesSlip, salesSlipWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ServiceResault();
    }
}
