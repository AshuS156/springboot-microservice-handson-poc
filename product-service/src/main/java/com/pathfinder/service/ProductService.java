package com.pathfinder.service;

import com.pathfinder.model.Product;
import com.pathfinder.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService{
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductRepository repository;

    public Product fetchProductById(Integer id) {
        logger.info("fetch product by id : {}", id);
        return  repository.findById(id).orElse(new Product());
    }

    public Product saveProducts(Product product) {
         Product savedProduct = repository.save(product);
        logger.debug("Product saved to DB : {}", savedProduct);
        return savedProduct;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }
}
