package com.pathfinder.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetails{


    private Integer productId;
    private String productName;
    private Long price;
    private String productCategory;

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

    @Override
    public String toString(){
        return "OrderDetails{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", productCategory='" + productCategory + '\'' +
                '}';
    }
}
