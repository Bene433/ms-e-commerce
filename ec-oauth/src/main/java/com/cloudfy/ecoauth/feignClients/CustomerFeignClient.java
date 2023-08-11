package com.cloudfy.ecoauth.feignClients;

import com.cloudfy.ecoauth.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "ec-customer", path = "/customer")
public interface CustomerFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Customer> getCustomerById(@PathVariable Long id);
}