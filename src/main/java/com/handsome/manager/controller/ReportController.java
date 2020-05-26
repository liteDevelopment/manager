package com.handsome.manager.controller;

import com.handsome.manager.service.ReportService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/pc/report")
public class ReportController {

    @Resource
    private ReportService reportService;

    @RequestMapping(value = "/saleDetails")
    @ResponseBody
    public Object saleDetails(Long userId, @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate, @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

        return reportService.getReportSaleDetails(userId, beginDate, endDate);
    }

}
