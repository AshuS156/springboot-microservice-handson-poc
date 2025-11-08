package com.pathfinder.controller;

import com.pathfinder.model.Product;
import com.pathfinder.service.ProductService;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController{

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer productId) {
        logger.info("Request payload : {}", productId);
        final Product product = productService.fetchProductById(productId);
        logger.debug("Final Response received from DB : {} ", product);
        return ResponseEntity.status(HttpStatus.SC_OK).body(product);
    }

    @PostMapping("/saveproduct")
    public ResponseEntity<Product> saveProduct( @RequestBody Product product) {
        logger.debug("Request paylaod : {}", product);
         Product saveProduct = productService.saveProducts(product);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(saveProduct);
    }

    @GetMapping("/fetchallproducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        final List<Product> productList = productService.getAll();
        logger.debug("List of all products : {}", productList);
        return  ResponseEntity.ok(productList);
    }
}
