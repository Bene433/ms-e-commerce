package com.cloudfy.ecshoppingcart.controllers;

import com.cloudfy.ecshoppingcart.models.dto.OrderRequest;
import com.cloudfy.ecshoppingcart.models.entities.Order;
import com.cloudfy.ecshoppingcart.services.RegisterOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/order/register")
public class RegisterOrderController {

    @Autowired
    private RegisterOrderService service;

    @PostMapping
    public ResponseEntity<Order> registerOrder(@RequestBody OrderRequest orderRequest){
        Order order = service.registerOrder(orderRequest);
        return ResponseEntity.ok().body(order);
    }
}