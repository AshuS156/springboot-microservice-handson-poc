package com.pathfinder.beans;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Product{

    private Integer productId;
    private String productName;

   public  Product() {
        System.out.println("Product class default constructor calling ......");
    }

    public  Product(Integer productId, String productName) {
       this.productId=  productId;
       this.productName = productName;
        System.out.println("Product class two param constructor calling");
    }

}
