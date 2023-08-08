package com.cloudfy.ecshoppingcart.services;

import com.cloudfy.ecshoppingcart.feignClients.ProductFeignClient;
import com.cloudfy.ecshoppingcart.models.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProductByIdService {

    @Autowired
    private ProductFeignClient productFeignClient;

    public Product findProductById(Long id){
        Product product = productFeignClient.findProductById(id).getBody();
        return new Product(product.getId(), product.getName(),product.getDescription(),product.getPrice());
    }
}