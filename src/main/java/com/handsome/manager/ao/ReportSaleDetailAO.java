package com.handsome.manager.ao;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ReportSaleDetailAO {

    private String userName;

    private String salesSlipCode;

    private String customerName;

    private String productName;

    private BigDecimal commission;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cutoffTime;
}
