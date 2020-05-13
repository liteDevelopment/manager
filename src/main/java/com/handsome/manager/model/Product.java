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
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 产品价格
     */
    private BigDecimal price;


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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
        ", id=" + id +
        ", name=" + name +
        ", price=" + price +
        "}";
    }
}
