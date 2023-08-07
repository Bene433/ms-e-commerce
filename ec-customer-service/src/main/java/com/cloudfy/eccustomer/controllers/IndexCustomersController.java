package com.cloudfy.eccustomer.controllers;

import com.cloudfy.eccustomer.models.entities.Customer;
import com.cloudfy.eccustomer.service.IndexCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/customer/index")
public class IndexCustomersController {

    @Autowired
    private IndexCustomersService service;

    @GetMapping
    public ResponseEntity<List<Customer>> index(){
        List<Customer> customers = service.index();
        return ResponseEntity.ok().body(customers);
    }
}