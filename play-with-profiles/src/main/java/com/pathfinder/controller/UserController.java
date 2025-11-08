package com.pathfinder.controller;

import com.pathfinder.beans.UserBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{

    @GetMapping
    public String userDetails() {
        UserBean userBean = new UserBean();
        System.out.println(userBean.toString());
        System.out.println("userBean.getUserName()" + userBean.getUserName());
        return "Hello";
    }
}
