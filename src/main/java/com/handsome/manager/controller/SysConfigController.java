package com.handsome.manager.controller;


import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.SysConfig;
import com.handsome.manager.service.SysConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author handsome
 * @since 2020-05-23
 */
@Controller
@RequestMapping("/pc/sysConfig")
public class SysConfigController {

    @Resource
    private SysConfigService sysConfigService;

    @RequestMapping(value = "/query")
    public ResponseEntity<ServiceResault> query(String code) {
        return ResponseEntity.ok(sysConfigService.getSysConfigByCode(code));
    }

    @RequestMapping(value = "/update")
    public ResponseEntity<ServiceResault> update(SysConfig sysConfig) {
        return ResponseEntity.ok(sysConfigService.update(sysConfig));
    }
}

