package com.handsome.manager.ao;

import com.handsome.manager.model.SalesSlip;
import lombok.Data;

@Data
public class SalesSlipAO extends SalesSlip {
    private String userName;
    private String customerName;
}
