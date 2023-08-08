package com.cloudfy.ecshoppingcart.controllers;

import com.cloudfy.ecshoppingcart.models.entities.Product;
import com.cloudfy.ecshoppingcart.services.GetProductByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/order/product")
public class GetProductController {

    @Autowired
    private GetProductByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        Product product = service.findProductById(id);
        return ResponseEntity.ok().body(product);
    }
}