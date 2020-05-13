package com.handsome.manager.model;

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
        ", status=" + status +
        "}";
    }
}
