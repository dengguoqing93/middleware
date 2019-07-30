package com.domain;

import java.util.Date;

/**
 * ${DESCRIPTION}
 * @author dengguoqing
 * @date 2019/5/1
 */
public class TOrder {
    /**
    * 订单编号
    */
    private String orderId;

    /**
    * 订单所属人
    */
    private String userName;

    /**
    * 订单状态
    */
    private Date orderStatus;

    /**
    * 订单创建时间
    */
    private Date createTime;

    /**
    * 订单信息修改时间
    */
    private Date updateTime;

    /**
    * 操作人员
    */
    private String operator;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Date orderStatus) {
        this.orderStatus = orderStatus;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}