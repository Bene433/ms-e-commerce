package com.cloudfy.ecshoppingcart.feignClients;

import com.cloudfy.ecshoppingcart.models.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ec-product", path = "/product")
public interface ProductFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Product> findProductById(@PathVariable Long id);
}