package com.mapper;

import com.domain.TProductAmount;

/**
 * ${DESCRIPTION}
 * @author dengguoqing
 * @date 2019/5/1
 */
public interface TProductAmountMapper {
    int insert(TProductAmount record);

    int insertSelective(TProductAmount record);
}