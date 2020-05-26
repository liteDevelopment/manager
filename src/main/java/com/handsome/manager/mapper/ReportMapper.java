package com.handsome.manager.mapper;

import com.handsome.manager.ao.ReportSaleDetailAO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ReportMapper {

    List<ReportSaleDetailAO> getReportSaleDetails(@Param("userId") Long userId, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

}
