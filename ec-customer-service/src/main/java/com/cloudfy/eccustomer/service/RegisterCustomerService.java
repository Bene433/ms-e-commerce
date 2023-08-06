package com.cloudfy.eccustomer.service;

import com.cloudfy.eccustomer.models.dto.CustomerDTO;
import com.cloudfy.eccustomer.models.entities.Customer;
import com.cloudfy.eccustomer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer register(CustomerDTO data){
        Customer customer = fromDTO(data);
        return repository.save(customer);
    }

    public Customer fromDTO(CustomerDTO data){
        return new Customer(data.getId(),data.getName(),data.getEmail(),data.getCellPhone(),data.getPassword());
    }
}