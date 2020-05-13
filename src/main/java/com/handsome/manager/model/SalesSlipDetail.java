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
public class SalesSlipDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 产品数量
     */
    private BigDecimal num;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 提成比例
     */
    private BigDecimal percentage;
    /**
     * 佣金
     */
    private BigDecimal commission;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "SalesSlipDetail{" +
        ", id=" + id +
        ", productId=" + productId +
        ", num=" + num +
        ", price=" + price +
        ", percentage=" + percentage +
        ", commission=" + commission +
        "}";
    }
}
