package com.syjpro.services;

import com.syjpro.entity.Users;
import com.syjpro.mapper.UsersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UsersMapper mapper;

    @Override
    public int login(Users user) {
        return 0;
    }
}