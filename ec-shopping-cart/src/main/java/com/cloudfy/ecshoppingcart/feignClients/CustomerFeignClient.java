package com.cloudfy.ecshoppingcart.feignClients;

import com.cloudfy.ecshoppingcart.models.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ec-customer", path = "/customer")
public interface CustomerFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Customer> findCustomerById(@PathVariable Long id);
}