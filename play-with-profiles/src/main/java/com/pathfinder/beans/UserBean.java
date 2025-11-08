package com.pathfinder.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserBean{

    @Value("${username}")
    private String userName;
    @Value("${pw}")
    private String pw;

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPw(String pw){
        this.pw = pw;
    }


    public String getUserName(){
        return userName;
    }

    public String getPw(){
        return pw;
    }


   public  UserBean() {
        System.out.println("UserBean created ....");
    }
    @Override
    public String toString() {
        return  "Username : " + userName + "PW : " + pw ;
    }
}
