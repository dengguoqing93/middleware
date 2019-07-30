package com.domain;

import java.util.Date;

/**
 * ${DESCRIPTION}
 * @author dengguoqing
 * @date 2019/5/1
 */
public class TOrderProduct {
    /**
    * 主键标识
    */
    private Integer id;

    /**
    * 订单标识码
    */
    private String orderId;

    /**
    * 产品标识码
    */
    private String productId;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}