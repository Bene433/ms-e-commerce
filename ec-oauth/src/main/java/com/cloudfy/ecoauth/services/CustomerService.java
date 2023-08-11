package com.cloudfy.ecoauth.services;

import com.cloudfy.ecoauth.entities.Customer;
import com.cloudfy.ecoauth.feignClients.CustomerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerFeignClient customerFeignClient;

    public Customer getCustomerById(Long id){
        Customer customer = customerFeignClient.getCustomerById(id).getBody();
        return customer;
    }
}