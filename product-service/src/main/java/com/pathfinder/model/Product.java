package com.pathfinder.model;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "product")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // @NotNull
   // @NotBlank
    private Integer productId;

    //@Min(value = 3, message = "Minimum 3 char required for prod name")
    private String productName;

   // @NotBlank(message = "price of product should not be blank")
    private Long price;

    private String productCategory;
   // @PastOrPresent(message = "Date of Manufacture should be preset or past date")
    private String dom;

    // @FutureOrPresent(message = "Date of Manufacture should be preset or past date")
    private String doe;


    public Integer getProductId(){
        return productId;
    }

    public void setProductId(Integer productId){
        this.productId = productId;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public Long getPrice(){
        return price;
    }

    public void setPrice(Long price){
        this.price = price;
    }

    public String getProductCategory(){
        return productCategory;
    }

    public void setProductCategory(String productCategory){
        this.productCategory = productCategory;
    }

    public String getDom(){
        return dom;
    }

    public void setDom(String dom){
        this.dom = dom;
    }

    public String getDoe(){
        return doe;
    }

    public void setDoe(String doe){
        this.doe = doe;
    }

    @Override
    public String toString(){
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", productCategory='" + productCategory + '\'' +
                ", dom='" + dom + '\'' +
                ", doe='" + doe + '\'' +
                '}';
    }
}
