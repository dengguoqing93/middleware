package com.learn.middleware.kafka.seri;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;

/**
 * 客户类序列化器
 *
 * @author dengguoqing
 * @date 2019/8/24
 */
public class CustomerSerializer implements Serializer<Customer> {

    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    /**
     * Customer对象被序列化成：表示customerID的4字节整数 表示customerName长度的4字节整数
     * 表示customerName的N个字节
     *
     * @param s        主题
     * @param customer 序列化数据
     * @return byte[] 序列化后的字节数组
     * @author dengguoqing
     * @date 2019/8/24
     * @since 1.0
     */
    @Override
    public byte[] serialize(String s, Customer customer) {

        byte[] serializedName;
        int stringSize;
        if (Objects.isNull(customer)) {
            return null;
        }
        if (Objects.nonNull(customer.getCustomerName())) {
            try {
                serializedName = customer.getCustomerName().getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new SerializationException(
                        "Error when serializing Customer to byte[]" + e);
            }
            stringSize = serializedName.length;
        } else {
            serializedName = new byte[0];
            stringSize = 0;
        }
        ByteBuffer buffer = ByteBuffer.allocate(4 + 4 + stringSize);
        buffer.putInt(customer.getCustomerID());
        buffer.putInt(stringSize);
        buffer.put(serializedName);

        return buffer.array();
    }

    @Override
    public void close() {

    }
}
