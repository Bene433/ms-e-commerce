package com.cloudfy.ecproduct.controllers;

import com.cloudfy.ecproduct.models.dto.ProductDTO;
import com.cloudfy.ecproduct.models.entities.Product;
import com.cloudfy.ecproduct.services.RegisterProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RestController
@RequestMapping(value = "/product/register")
public class RegisterProductController {

    @Autowired
    private RegisterProductService service;

    @PostMapping
    public ResponseEntity<Product> registerProduct(@RequestBody ProductDTO productDTO){
        Product product = service.register(productDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}