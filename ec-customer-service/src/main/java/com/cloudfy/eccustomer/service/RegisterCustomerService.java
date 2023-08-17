package com.cloudfy.eccustomer.service;

import com.cloudfy.eccustomer.models.dto.CustomerDTO;
import com.cloudfy.eccustomer.models.entities.Customer;
import com.cloudfy.eccustomer.repositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer register(CustomerDTO dataDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(dataDTO, customer);
        return repository.save(customer);
    }
}