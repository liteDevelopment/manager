package com.handsome.manager.controller;


import com.handsome.manager.ao.DatatablesResult;
import com.handsome.manager.ao.SalesSlipAO;
import com.handsome.manager.ao.SalesSlipDetailAO;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.SalesSlip;
import com.handsome.manager.model.SalesSlipDetail;
import com.handsome.manager.service.SalesSlipDetailService;
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
    @Resource
    private SalesSlipDetailService salesSlipDetailService;

    @RequestMapping(value = "/dataGrid")
    public ResponseEntity<DatatablesResult> list(SalesSlip salesSlip,
                                                 @RequestParam(value = "draw") int draw,
                                                 @RequestParam(value = "start") String start,
                                                 @RequestParam(value = "length") String length) {
        int rows = Integer.parseInt(length);
        int page = (Integer.parseInt(start) / rows) + 1;
        List<SalesSlipAO> users = salesSlipService.list(rows, page, salesSlip);
        DatatablesResult pageResult = new DatatablesResult<SalesSlip>();
        pageResult.setData(users);
        pageResult.setDraw(draw);
        pageResult.setRecordsTotal(salesSlipService.count(salesSlip));
        pageResult.setRecordsFiltered(pageResult.getRecordsTotal());
        return ResponseEntity.ok(pageResult);
    }

    @RequestMapping(value = "/detail/dataGrid")
    public ResponseEntity<DatatablesResult> detailList(SalesSlipDetail salesSlipDetail,
                                                 @RequestParam(value = "draw") int draw,
                                                 @RequestParam(value = "start") String start,
                                                 @RequestParam(value = "length") String length) {
        int rows = Integer.parseInt(length);
        int page = (Integer.parseInt(start) / rows) + 1;
        List<SalesSlipDetailAO> users = salesSlipDetailService.list(rows, page, salesSlipDetail.getSalesSlipId());
        DatatablesResult pageResult = new DatatablesResult<SalesSlip>();
        pageResult.setData(users);
        pageResult.setDraw(draw);
        pageResult.setRecordsTotal(salesSlipDetailService.count());
        pageResult.setRecordsFiltered(pageResult.getRecordsTotal());
        return ResponseEntity.ok(pageResult);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResault> delete(@RequestParam(value = "id") String id) {
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        salesSlipService.del(id);
        return ResponseEntity.ok(new ServiceResault());
    }

    @RequestMapping(value = "/detail/delete", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResault> detailDelete(@RequestParam(value = "id") String id) {
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        salesSlipDetailService.del(id);
        return ResponseEntity.ok(new ServiceResault());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<ServiceResault> save(SalesSlip salesSlip) {
        ServiceResault sr;
        if (StringUtils.isEmpty(salesSlip.getId())) {
            sr = salesSlipService.add(salesSlip);
        } else {
            sr = salesSlipService.update(salesSlip);
        }
        return ResponseEntity.ok(sr);
    }

    @RequestMapping(value = "/detail/save", method = RequestMethod.POST)
    public ResponseEntity<ServiceResault> detailSave(SalesSlipDetail salesSlipDetail) {
        ServiceResault sr;
        if (StringUtils.isEmpty(salesSlipDetail.getId())) {
            sr = salesSlipDetailService.add(salesSlipDetail);
        } else {
            sr = salesSlipDetailService.update(salesSlipDetail);
        }
        return ResponseEntity.ok(sr);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResponseEntity<ServiceResault> query(String id) {
        return ResponseEntity.ok(salesSlipService.query(id));
    }

    @RequestMapping(value = "/detail/query", method = RequestMethod.GET)
    public ResponseEntity<ServiceResault> detailQuery(String id) {
        return ResponseEntity.ok(salesSlipDetailService.query(id));
    }
}

