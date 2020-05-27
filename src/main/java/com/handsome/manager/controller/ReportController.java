package com.handsome.manager.controller;

import com.handsome.manager.ao.ReportSaleDetailAO;
import com.handsome.manager.service.ReportService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/pc/report")
public class ReportController {

    @Resource
    private ReportService reportService;

    @RequestMapping(value = "/saleDetails")
    public Object saleDetails(Model model, Long userId, @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate, @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<ReportSaleDetailAO> saleDetails = (List<ReportSaleDetailAO>) reportService.getReportSaleDetails(userId, beginDate, endDate).getData();
        model.addAttribute("saleDetails", saleDetails);
        BigDecimal totalCommission = new BigDecimal(0);
        if (!CollectionUtils.isEmpty(saleDetails)) {
            for (ReportSaleDetailAO saleDetail: saleDetails) {
                totalCommission = totalCommission.add(saleDetail.getCommission());
            }
        }
        model.addAttribute("totalCommission", totalCommission);
        return "report/reportSaleDetails_table";
    }

}
