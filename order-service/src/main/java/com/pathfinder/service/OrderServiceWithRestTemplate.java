package com.pathfinder.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pathfinder.bean.OrderDetails;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceWithRestTemplate{

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceWithRestTemplate.class);
    @Autowired
    private RestTemplate restTemplate;

    @Value("${product-service-base-url}")
    String productServiceBaseUrl;

    public OrderDetails getOrderDetailsByPidUsingRestTemplate(Integer productId){
        OrderDetails orderDetails = null;
        logger.info("starting of getOrderDetailsByPidUsingRestTemplate  !!!!!!!");
       // String url = "http://localhost:5002/api/product/".concat(productId.toString());
        String baseUrl = productServiceBaseUrl.endsWith("/") ? productServiceBaseUrl : productServiceBaseUrl.concat("/");
        String relativeUrl = "".concat(productId.toString());
        String fullUrl = baseUrl.concat(relativeUrl);
        logger.debug("Full URL to call product service : {}",fullUrl);
        final ResponseEntity<String> response = restTemplate.getForEntity(fullUrl,String.class);
        logger.debug("response : {}",response);
        orderDetails = constructOrderDetailObject(response);
        return orderDetails;
    }

    public OrderDetails getOrderDetailsUsingLoadBalancer(Integer productId){
        logger.info("starting of getOrderDetailsByPidUsingLoadbBlancer  !!!!!!!");
        OrderDetails orderDetails = null;
        String baseUrl = productServiceBaseUrl.endsWith("/") ? productServiceBaseUrl : productServiceBaseUrl.concat("/");
        String relativeUrl = "".concat(productId.toString());
        String fullUrl = baseUrl.concat(relativeUrl);
        logger.debug("Full URL to call product service : {}",fullUrl);
        final ResponseEntity<String> response = restTemplate.getForEntity(fullUrl , String.class);
        logger.debug("response : {}",response);
        orderDetails = constructOrderDetailObject(response);
        return orderDetails;
    }

    public List<OrderDetails> getAllOrderDetailsUsingRestTemplate(){
        //String url = "http://localhost:5002/api/product/fetchallproducts";
        //logger.debug("product service url to get all products : {}",url);
        String baseUrl = productServiceBaseUrl.endsWith("/") ? productServiceBaseUrl : productServiceBaseUrl.concat("/");
        String relativeUrl = "fetchallproducts";
        String fullUrl = baseUrl.concat(relativeUrl);
        logger.debug("Full URL to call product service : {}",fullUrl);
        final ResponseEntity<String> ProductList = restTemplate.exchange(fullUrl,HttpMethod.GET,null,String.class);
        logger.debug("Response received from downstream system is : {}",ProductList);

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(ProductList.getBody(),new TypeReference<List<OrderDetails>>(){
            });
        } catch (JsonProcessingException e) {
            logger.error("Errro occured while parshing : {}",e);
        }

        return null;
    }

    private OrderDetails constructOrderDetailObject(ResponseEntity<String> response){
        if (Objects.nonNull(response) && StringUtils.isNoneBlank(response.getBody())) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(response.getBody(),OrderDetails.class);
            } catch (JsonProcessingException e) {
                logger.error("Errro occured while parshing response : {}",e);
            } catch (Exception e) {
                logger.error("Errro occured while parshing response : {}",e);
            }
        }
        return null;
    }

}
