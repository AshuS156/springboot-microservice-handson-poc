package com.pathfinder.service;


import com.pathfinder.appconfig.ProductServiceProxy;
import com.pathfinder.bean.OrderDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceWithFeignClient{

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceWithFeignClient.class);

    @Autowired
    ProductServiceProxy productServiceProxy;

    public OrderDetails getOrderDetailsByProductId(Integer productId){
        OrderDetails orderDetails = null;
        logger.info("starting of getOrderDetailsByProductId  !!!!!!!");
        final ResponseEntity<OrderDetails> response = productServiceProxy.getProductById(productId);
        logger.debug("response returned by getProductById api  : {}",response.getBody());
       return response.getBody();
    }

    public List<OrderDetails> getAllOrderDetails(){

        final ResponseEntity<List<OrderDetails>> allProducts = productServiceProxy.getAllProducts();
        logger.debug("response returned by getProductById api  : {}",allProducts.getBody());
        return  allProducts.getBody();
    }

}
