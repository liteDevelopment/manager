package com.handsome.manager.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.SysConfig;
import com.handsome.manager.mapper.SysConfigMapper;
import com.handsome.manager.service.SysConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author handsome
 * @since 2020-05-23
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {

    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public ServiceResault getSysConfigByCode(String code) {
        Wrapper<SysConfig> sysConfigWrapper = new EntityWrapper<SysConfig>();
        sysConfigWrapper.eq("code", "percentage");
        List<SysConfig> salesSlips = sysConfigMapper.selectList(sysConfigWrapper);
        return new ServiceResault(CollectionUtils.isEmpty(salesSlips) ? null : salesSlips.get(0));
    }
}
