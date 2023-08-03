package com.cloudfy.ecproduct.controllers;

import com.cloudfy.ecproduct.models.entities.Product;
import com.cloudfy.ecproduct.services.GetProductByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/product")
public class GetProductByIdController {

    @Autowired
    private GetProductByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = service.getProductById(id);
        return ResponseEntity.ok().body(product);
    }
}