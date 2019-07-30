package com.mapper;

import com.domain.TUser;

/**
 * ${DESCRIPTION}
 * @author dengguoqing
 * @date 2019/5/1
 */
public interface TUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}