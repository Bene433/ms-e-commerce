package com.cloudfy.ecshoppingcart.services;

import com.cloudfy.ecshoppingcart.feignClients.CustomerFeignClient;
import com.cloudfy.ecshoppingcart.models.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerByIdService {

    @Autowired
    private CustomerFeignClient customerFeignClient;

    public Customer getCustomer(Long id){
        Customer customer = customerFeignClient.findCustomerById(id).getBody();
        return new Customer(customer.getId(),customer.getName(), customer.getEmail(), customer.getCellPhone(), customer.getPassword());
    }
}