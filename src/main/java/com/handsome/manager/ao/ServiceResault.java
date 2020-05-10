package com.handsome.manager.ao;

import java.util.HashMap;
import java.util.Map;

public class ServiceResault {

    public ServiceResault() {

    }
    public ServiceResault(Object data) {
        this.data = data;
    }

    public ServiceResault(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServiceResault(Object data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    private int code = 1;

    private String msg;

    private Object data;

    private Map<String, Object> attr = new HashMap<String, Object>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Map<String, Object> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, Object> attr) {
        this.attr = attr;
    }
}
