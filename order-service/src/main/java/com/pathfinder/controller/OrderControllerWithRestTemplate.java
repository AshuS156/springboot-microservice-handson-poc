package com.pathfinder.controller;

import com.pathfinder.bean.OrderDetails;
import com.pathfinder.service.OrderServiceWithRestTemplate;
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
@ConditionalOnProperty(prefix = "OrderControllerWithRestTemplate" , value = "unload", havingValue = "true" , matchIfMissing = false)
public class OrderControllerWithRestTemplate{

    private static final Logger logger = LoggerFactory.getLogger(OrderControllerWithRestTemplate.class);
    @Autowired
    OrderServiceWithRestTemplate orderServiceWithRestTemplate;
    @GetMapping("/{productId}")
    public ResponseEntity<OrderDetails> getOrderDetailsBasedOnProductIdWithLoadBalancer(@PathVariable("productId") Integer productId) {

        final OrderDetails orderDetailsByPidUsingRestTemplate = orderServiceWithRestTemplate.getOrderDetailsByPidUsingRestTemplate(productId);
        return  ResponseEntity.ok(orderDetailsByPidUsingRestTemplate);
    }

    @GetMapping("/orderhistory")
    public ResponseEntity<List<OrderDetails>> getAllOrderDetailsWithLoadBalancer() {
        final List<OrderDetails> allOrders = orderServiceWithRestTemplate.getAllOrderDetailsUsingRestTemplate();
        logger.debug("Order Details list : {}", allOrders);
        return ResponseEntity.ok(allOrders);
    }

    @GetMapping("/loadbalancer/{productId}")
    public ResponseEntity<OrderDetails> getOrderDetailsWithLoadBalancer(@PathVariable("productId") Integer productId) {

        final OrderDetails orderDetailsByPidUsingRestTemplate = orderServiceWithRestTemplate.getOrderDetailsUsingLoadBalancer(productId);
        return  ResponseEntity.ok(orderDetailsByPidUsingRestTemplate);
    }
}
