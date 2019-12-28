package com.learn.middleware.kafka.seri;

/**
 * 客户示例类
 *
 * @author dengguoqing
 * @date 2019/8/24
 */
public class Customer {
    private int customerID;
    private String customerName;

    public Customer(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }
}
