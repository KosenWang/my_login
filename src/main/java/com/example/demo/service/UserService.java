package com.example.demo.service;

import javax.annotation.Resource;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;

import org.springframework.stereotype.Service;


@Service
public class UserService {
    //将dao层属性注入service层
    @Resource
    UserMapper userMapper;

    public User LoginIn(String username, String password) {
        return userMapper.getInfo(username,password);
    }
  
    public void Insert(String username,String password){
        userMapper.saveInfo(username, password);
    }
}
