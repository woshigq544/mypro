package com.syjpro.mapper;

import com.syjpro.entity.Users;

public interface UsersMapper {
    Users selectByLogin(Users user);

    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}