package com.cloudfy.eccustomer.controllers;

import com.cloudfy.eccustomer.models.dto.CustomerDTO;
import com.cloudfy.eccustomer.models.entities.Customer;
import com.cloudfy.eccustomer.service.UpdateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(value = "/update/customer")
public class UpdateCustomerController {

    @Autowired
    private UpdateCustomerService service;

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> update(@RequestBody CustomerDTO data, @PathVariable Long id){
        Customer customer = service.fromDTO(data);
        customer.setId(id);
        service.update(customer);
        return ResponseEntity.noContent().build();
    }
}