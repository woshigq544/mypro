package com.syjpro.mapper;

import com.syjpro.entity.Users;


public interface UsersMapper {
    Users selectByLogin(Users record);

    Users toRegist(Users record);

    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}