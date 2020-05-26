package com.handsome.manager.service;

import com.handsome.manager.ao.ReportSaleDetailAO;
import com.handsome.manager.ao.ServiceResault;

import java.util.Date;
import java.util.List;

public interface ReportService {

    ServiceResault getReportSaleDetails(Long userId, Date beginDate, Date endDate);

}
