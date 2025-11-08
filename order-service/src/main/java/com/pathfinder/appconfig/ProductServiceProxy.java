package com.pathfinder.appconfig;

import com.pathfinder.bean.OrderDetails;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name = "product-service" , url = "http://localhost:5002/api/product/")
@FeignClient(name ="product-service" ,path = "/api/product/")
public interface ProductServiceProxy{

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> getProductById(@PathVariable("id") Integer productId) ;

    @GetMapping("/fetchallproducts")
    public ResponseEntity<List<OrderDetails>> getAllProducts();
}
