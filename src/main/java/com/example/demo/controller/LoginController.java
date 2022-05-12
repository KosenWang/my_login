package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class LoginController {
    //将Service注入Web层
    @Resource
    UserService userService;

    //实现登录
    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String username,String password){
        User user = userService.LoginIn(username, password);
        // Log.info("username:{}",username);
        // Log.info("password:{}",password);
        if(user!=null){
            return "success";
        }else {
            return "error";
        }
    }

    //实现注册功能
    @RequestMapping("/signup")
    public String disp(){
        return "signup";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String signUp(String username,String password){
        userService.Insert(username, password);
        return "success";
    }
}
