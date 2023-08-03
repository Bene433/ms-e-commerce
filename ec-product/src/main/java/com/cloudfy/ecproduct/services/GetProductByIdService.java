package com.cloudfy.ecproduct.services;

import com.cloudfy.ecproduct.models.entities.Product;
import com.cloudfy.ecproduct.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProductByIdService {

    @Autowired
    private ProductRepository repository;

    public Product getProductById(Long id){
        Product product = repository.findById(id).get();
        return product;
    }

}