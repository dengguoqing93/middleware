package com.domain;

/**
 * ${DESCRIPTION}
 * @author dengguoqing
 * @date 2019/5/1
 */
public class TProductAmount {
    /**
    * 产品编号
    */
    private String productNo;

    /**
    * 产品库存
    */
    private Integer productAmount;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }
}