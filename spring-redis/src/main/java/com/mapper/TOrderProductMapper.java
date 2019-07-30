package com.mapper;

import com.domain.TOrderProduct;

/**
 * ${DESCRIPTION}
 * @author dengguoqing
 * @date 2019/5/1
 */
public interface TOrderProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TOrderProduct record);

    int insertSelective(TOrderProduct record);

    TOrderProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TOrderProduct record);

    int updateByPrimaryKey(TOrderProduct record);
}