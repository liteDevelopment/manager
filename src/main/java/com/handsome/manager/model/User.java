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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private Long roleId;
    private String name;
    private String password;
    private String phone;
    /**
     * 状态 1有效 0删除
     */
    private Boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                ", id=" + id +
                ", roleId=" + roleId +
                ", name=" + name +
                ", password=" + password +
                ", phone=" + phone +
                ", status=" + status +
                "}";
    }
}
