package com.pathfinder.beans;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBean{

    UserBean() {
        System.out.println("User bean default cons calling");
    }
}
