package com.handsome.manager.service.impl;

import com.handsome.manager.ao.ReportSaleDetailAO;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.mapper.ReportMapper;
import com.handsome.manager.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private ReportMapper reportMapper;

    @Override
    public ServiceResault getReportSaleDetails(Long userId, Date beginDate, Date endDate) {
        List<ReportSaleDetailAO> reportSaleDetailAOS = reportMapper.getReportSaleDetails(userId, beginDate, endDate);
        return new ServiceResault(reportSaleDetailAOS);
    }
}
