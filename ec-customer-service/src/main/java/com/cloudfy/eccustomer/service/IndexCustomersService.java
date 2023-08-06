package com.cloudfy.eccustomer.service;

import com.cloudfy.eccustomer.models.entities.Customer;
import com.cloudfy.eccustomer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexCustomersService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> index(){
        List<Customer> customers = repository.findAll();
        return customers;
    }
}