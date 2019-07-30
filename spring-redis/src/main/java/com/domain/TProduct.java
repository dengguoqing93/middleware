package com.domain;

/**
 * ${DESCRIPTION}
 * @author dengguoqing
 * @date 2019/5/1
 */
public class TProduct {
    /**
    * 产品标识
    */
    private String productId;

    /**
    * 产品编号
    */
    private String productNo;

    /**
    * 产品名称
    */
    private String productName;

    /**
    * 产品状态
    */
    private Short productStatus;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Short getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Short productStatus) {
        this.productStatus = productStatus;
    }
}