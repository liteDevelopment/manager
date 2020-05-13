package com.handsome.manager.controller;


import com.handsome.manager.ao.DatatablesResult;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.SalesSlip;
import com.handsome.manager.service.SalesSlipService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author handsome
 * @since 2020-05-13
 */
@Controller
@RequestMapping("/pc/salesSlip")
public class SalesSlipController {
    @Resource
    private SalesSlipService salesSlipService;

    @RequestMapping(value = "/dataGrid")
    public ResponseEntity<DatatablesResult> list(SalesSlip salesSlip,
                                                 @RequestParam(value = "draw") int draw,
                                                 @RequestParam(value = "start") String start,
                                                 @RequestParam(value = "length") String length) {
        int rows = Integer.parseInt(length);
        int page = (Integer.parseInt(start) / rows) + 1;
        List<SalesSlip> users = new ArrayList<SalesSlip>();
        DatatablesResult pageResult = new DatatablesResult<SalesSlip>();
        pageResult.setData(users);
        pageResult.setDraw(draw);
        pageResult.setRecordsTotal(20);
        pageResult.setRecordsFiltered(pageResult.getRecordsTotal());
        return ResponseEntity.ok(pageResult);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<ServiceResault> delete(@RequestParam(value = "id") String id) {
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        salesSlipService.delSalesSlip(id);
        return ResponseEntity.ok(new ServiceResault());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<ServiceResault> save(SalesSlip salesSlip) {
        if (StringUtils.isEmpty(salesSlip.getId())) {
            salesSlipService.addSalesSlip(salesSlip);
        } else {
            salesSlipService.updateSalesSlip(salesSlip);
        }
        return ResponseEntity.ok(new ServiceResault());
    }
}
