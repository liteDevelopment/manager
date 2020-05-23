package com.handsome.manager.service;

import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.SysConfig;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author handsome
 * @since 2020-05-23
 */
public interface SysConfigService extends IService<SysConfig> {

    ServiceResault getSysConfigByCode(String code);

}
