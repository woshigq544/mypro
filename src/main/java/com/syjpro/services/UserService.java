package com.syjpro.services;


import com.syjpro.entity.Users;

public interface UserService{
    Users login(Users user);

    Users toRegist(Users user);

    int doingRegist(Users user);
}
