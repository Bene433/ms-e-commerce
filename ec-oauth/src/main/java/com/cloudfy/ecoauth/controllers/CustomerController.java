package com.cloudfy.ecoauth.controllers;

import com.cloudfy.ecoauth.entities.Customer;
import com.cloudfy.ecoauth.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/oauth/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer customer = service.getCustomerById(id);
        return ResponseEntity.ok().body(customer);
    }
}