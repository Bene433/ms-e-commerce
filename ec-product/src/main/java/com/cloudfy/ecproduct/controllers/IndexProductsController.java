package com.cloudfy.ecproduct.controllers;

import com.cloudfy.ecproduct.models.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/products")
public class IndexProductsController {

    @GetMapping
    public ResponseEntity<Product> index(){
        Product p1 = new Product(1L,"Headset Logitech g435", "Headset com fio",299.9, 50);
        return ResponseEntity.ok().body(p1);
    }

}