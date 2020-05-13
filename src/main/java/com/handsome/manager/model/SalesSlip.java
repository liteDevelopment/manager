package com.handsome.manager.model;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author handsome
 * @since 2020-05-13
 */
public class SalesSlip implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 销售id
     */
    private Long userId;
    /**
     * 客户id
     */
    private Long customerId;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 产品数量
     */
    private BigDecimal num;
    private BigDecimal percentage;
    /**
     * 佣金
     */
    private BigDecimal commission;
    /**
     * 有效性
     */
    private Boolean status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SalesSlip{" +
        ", id=" + id +
        ", userId=" + userId +
        ", customerId=" + customerId +
        ", productId=" + productId +
        ", num=" + num +
        ", percentage=" + percentage +
        ", commission=" + commission +
        ", status=" + status +
        "}";
    }
}
