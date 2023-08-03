package com.cloudfy.ecproduct.services;

import com.cloudfy.ecproduct.models.entities.Product;
import com.cloudfy.ecproduct.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexProductsService {

    @Autowired
    private ProductRepository repository;

    public List<Product> index(){
        List<Product> list = new ArrayList<>();
        list = repository.findAll();
        return list;
    }
}