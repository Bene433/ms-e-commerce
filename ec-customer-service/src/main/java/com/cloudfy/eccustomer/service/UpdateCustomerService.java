package com.cloudfy.eccustomer.service;

import com.cloudfy.eccustomer.models.dto.CustomerDTO;
import com.cloudfy.eccustomer.models.entities.Customer;
import com.cloudfy.eccustomer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer update(Customer data){
        Customer customerToOupdate = findById(data.getId());
        updateData(customerToOupdate, data);
        return repository.save(customerToOupdate);
    }

    public void updateData(Customer customerFromDB, Customer customerToUpadate){
        customerFromDB.setName(customerToUpadate.getName());
        customerFromDB.setEmail(customerToUpadate.getEmail());
        customerFromDB.setCellPhone(customerToUpadate.getCellPhone());
        customerFromDB.setPassword(customerToUpadate.getPassword());
    }

    public Customer findById(Long id){
        Customer customer = repository.findById(id).get();
        return customer;
    }

    public Customer fromDTO(CustomerDTO data){
        return new Customer(data.getId(),data.getName(),data.getEmail(),data.getCellPhone(),data.getPassword());
    }
}