package com.syjpro.services;

import com.syjpro.entity.Users;
import com.syjpro.mapper.UsersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UsersMapper usersMapper;

    @Override
    public Users login(Users user) {
        return usersMapper.selectByLogin(user);
    }

    //检查注册用户信息是否已存在
    @Override
    public Users toRegist(Users user) {

        return usersMapper.toRegist(user);
    }

    @Override
    public int doingRegist(Users user) {
        return usersMapper.insertSelective(user);
    }
}
