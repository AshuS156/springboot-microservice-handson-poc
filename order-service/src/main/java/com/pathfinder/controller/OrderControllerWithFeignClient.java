package com.pathfinder.controller;

import com.pathfinder.bean.OrderDetails;
import com.pathfinder.service.OrderServiceWithFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orderdetails")
//@ConditionalOnProperty(prefix = "OrderControllerWithRestTemplate" , value = "unload", havingValue = "true" , matchIfMissing = false)
public class OrderControllerWithFeignClient{

    private static final Logger logger = LoggerFactory.getLogger(OrderControllerWithFeignClient.class);
    @Autowired
    OrderServiceWithFeignClient orderServiceWithFeignClient;
    @GetMapping("/{productId}")
    public ResponseEntity<OrderDetails> getOrderDetailsBasedOnProductId(@PathVariable("productId") Integer productId) {

        final OrderDetails orderDetailsByProductId = orderServiceWithFeignClient.getOrderDetailsByProductId(productId);
        return  ResponseEntity.ok(orderDetailsByProductId);
    }

    @GetMapping("/orderhistory")
    public ResponseEntity<List<OrderDetails>> getAllOrderDetails() {
        final List<OrderDetails> allOrders = orderServiceWithFeignClient.getAllOrderDetails();
        logger.debug("Order Details list : {}", allOrders);
        return ResponseEntity.ok(allOrders);
    }
}
