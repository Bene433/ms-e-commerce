package com.cloudfy.ecproduct.controllers;

import com.cloudfy.ecproduct.models.entities.Product;
import com.cloudfy.ecproduct.services.IndexProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/product/index")
public class IndexProductsController {

    @Autowired
    private IndexProductsService service;

    @GetMapping
    public ResponseEntity<List<Product>> index(){
        List<Product> list = service.index();
        return ResponseEntity.ok().body(list);
    }
}