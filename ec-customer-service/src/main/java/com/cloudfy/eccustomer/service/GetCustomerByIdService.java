package com.cloudfy.eccustomer.service;

import com.cloudfy.eccustomer.models.entities.Customer;
import com.cloudfy.eccustomer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerByIdService {

    @Autowired
    private CustomerRepository repository;

    public Customer getCustomerById(Long id){
        Customer customer = repository.findById(id).get();
        return customer;
    }
}