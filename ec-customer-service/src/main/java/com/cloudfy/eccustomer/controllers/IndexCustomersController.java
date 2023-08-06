package com.cloudfy.eccustomer.controllers;

import com.cloudfy.eccustomer.models.entities.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/customers")
public class IndexCustomersController {

    @GetMapping
    public ResponseEntity<List<Customer>> index(){
        List<Customer> list = new ArrayList<>();
        Customer c1 = new Customer(1L, "Matheus", "matheus@teste.com", "99999-9999", "12345");
        Customer c2 = new Customer(2L, "Carlos", "carlos@teste.com", "99999-9999", "12345");
        list.add(c1);
        list.add(c2);
        return ResponseEntity.ok().body(list);
    }
}