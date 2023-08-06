package com.cloudfy.eccustomer.controllers;

import com.cloudfy.eccustomer.models.entities.Customer;
import com.cloudfy.eccustomer.service.GetCustomerByIdService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/customer")
public class GetCustomerByIdController {

    @Autowired
    private GetCustomerByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer customer = service.getCustomerById(id);
        return ResponseEntity.ok().body(customer);
    }
}