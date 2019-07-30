package com.mapper;

import com.domain.TProduct;

/**
 * ${DESCRIPTION}
 * @author dengguoqing
 * @date 2019/5/1
 */
public interface TProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    TProduct selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKey(TProduct record);
}