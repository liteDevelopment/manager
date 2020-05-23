package com.handsome.manager.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

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

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long salesSlipId;
    /**
     * 产品id
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
    /**
     * 结算时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cutoffTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSalesSlipId() {
        return salesSlipId;
    }

    public void setSalesSlipId(Long salesSlipId) {
        this.salesSlipId = salesSlipId;
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

    public Date getCutoffTime() {
        return cutoffTime;
    }

    public void setCutoffTime(Date cutoffTime) {
        this.cutoffTime = cutoffTime;
    }

    @Override
    public String toString() {
        return "SalesSlipDetail{" +
                ", id=" + id +
                ", salesSlipId=" + salesSlipId +
                ", productId=" + productId +
                ", num=" + num +
                ", price=" + price +
                ", percentage=" + percentage +
                ", commission=" + commission +
                ", cutoffTime=" + cutoffTime +
                "}";
    }
}
