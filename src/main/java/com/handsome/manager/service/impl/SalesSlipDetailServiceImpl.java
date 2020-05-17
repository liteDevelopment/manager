package com.handsome.manager.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.handsome.manager.ao.SalesSlipDetailAO;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.SalesSlipDetail;
import com.handsome.manager.mapper.SalesSlipDetailMapper;
import com.handsome.manager.service.SalesSlipDetailService;
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
public class SalesSlipDetailServiceImpl extends ServiceImpl<SalesSlipDetailMapper, SalesSlipDetail> implements SalesSlipDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesSlipDetailServiceImpl.class);

    @Resource
    private SalesSlipDetailMapper salesSlipDetailMapper;

    @Override
    public List<SalesSlipDetailAO> list(int rows, int page) {
        Page p = new Page(page, rows);
        List<SalesSlipDetailAO> salesSlipDetails = salesSlipDetailMapper.getSalesSlipDetails(p.getOffset(), p.getSize());
        return salesSlipDetails;
    }

    @Override
    public int count() {
        Wrapper<SalesSlipDetail> salesSlipDettailWrapper = new EntityWrapper<SalesSlipDetail>();
        return salesSlipDetailMapper.selectCount(salesSlipDettailWrapper);
    }

    @Override
    public ServiceResault query(String id) {
        SalesSlipDetail salesSlipDetail = salesSlipDetailMapper.selectById(id);
        return new ServiceResault(salesSlipDetail);
    }

    @Override
    public ServiceResault add(SalesSlipDetail salesSlipDetail) {
        return null;
    }

    @Override
    public ServiceResault update(SalesSlipDetail salesSlipDetail) {
        return null;
    }

    @Override
    public ServiceResault del(String id) {
        salesSlipDetailMapper.deleteById(id);
        return new ServiceResault();
    }

}
