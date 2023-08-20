package com.cloudfy.eccustomer.controllers;

import com.cloudfy.eccustomer.models.dto.CustomerDTO;
import com.cloudfy.eccustomer.models.entities.Customer;
import com.cloudfy.eccustomer.service.RegisterCustomerService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RestController
@RequestMapping(value = "/customer/register")
public class RegisterCustomerController {

    @Autowired
    private RegisterCustomerService service;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseEntity<Customer> register(@RequestBody CustomerDTO data){
        Customer customer = service.register(data);
        String routingKey = "emails.v1.customer-created";
        rabbitTemplate.convertAndSend(routingKey, customer.getEmail());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}