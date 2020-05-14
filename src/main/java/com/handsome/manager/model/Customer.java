package com.handsome.manager.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author handsome
 * @since 2020-05-13
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 联系方式
     */
    private String contact;
    /**
     * 是否在校 0 不在 1 在
     */
    private Boolean status;
    /**
     * 所选课程id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long productId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Customer{" +
        ", id=" + id +
        ", name=" + name +
        ", contact=" + contact +
        ", status=" + status +
        ", productId=" + productId +
        "}";
    }
}
