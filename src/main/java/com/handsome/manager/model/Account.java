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
 * @since 2020-05-03
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String account;
    /**
     * 1-手机号
     */
    private Integer type;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", type=" + type +
                ", userId=" + userId +
                '}';
    }
}
