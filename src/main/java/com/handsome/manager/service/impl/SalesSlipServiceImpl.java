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
import java.util.Date;
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
    public List<SalesSlipAO> list(int rows, int page, SalesSlip query) {
        Page p = new Page(page, rows);
//        Wrapper<SalesSlip> salesSlipWrapper = new EntityWrapper<SalesSlip>();
//        salesSlipWrapper.eq("status", true);
//        List<SalesSlip> salesSlips = salesSlipMapper.selectPage(p, salesSlipWrapper);
        List<SalesSlipAO> salesSlips = salesSlipMapper.getSalesSlips(p.getOffset(), p.getSize(), null == query ? null : query.getUserId());
        return salesSlips;
    }

    @Override
    public int count(SalesSlip query) {
        Wrapper<SalesSlip> salesSlipWrapper = new EntityWrapper<SalesSlip>();
        salesSlipWrapper.eq("status", true);
        salesSlipWrapper.eq("user_id", query.getUserId());
        return salesSlipMapper.selectCount(salesSlipWrapper);
    }

    @Override
    public ServiceResault query(String id) {
        SalesSlip salesSlip = salesSlipMapper.selectById(id);
        return new ServiceResault(salesSlip);
    }

    @Override
    public ServiceResault add(SalesSlip salesSlip) {
        Wrapper<SalesSlip> checkWrapper = new EntityWrapper<SalesSlip>();
        checkWrapper.eq("code", salesSlip.getCode());
        Integer num = salesSlipMapper.selectCount(checkWrapper);
        if (num > 0) {
            return new ServiceResault(0, "单号重复！");
        }

        salesSlip.setCreateTime(new Date());
        salesSlipMapper.insert(salesSlip);
        return new ServiceResault();
    }

    @Override
    public ServiceResault update(SalesSlip salesSlip) {
        Wrapper<SalesSlip> checkWrapper = new EntityWrapper<SalesSlip>();
        checkWrapper.eq("code", salesSlip.getCode());
        checkWrapper.ne("id", salesSlip.getId());
        Integer num = salesSlipMapper.selectCount(checkWrapper);
        if (num > 0) {
            return new ServiceResault(0, "单号重复！");
        }

        Wrapper<SalesSlip> salesSlipWrapper = new EntityWrapper<SalesSlip>();
        salesSlipWrapper.eq("id", salesSlip.getId());
        salesSlipMapper.update(salesSlip, salesSlipWrapper);
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
