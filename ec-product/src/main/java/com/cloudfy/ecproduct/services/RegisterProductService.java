package com.cloudfy.ecproduct.services;

import com.cloudfy.ecproduct.models.dto.ProductDTO;
import com.cloudfy.ecproduct.models.entities.Product;
import com.cloudfy.ecproduct.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterProductService {

    @Autowired
    private ProductRepository repository;

    public Product register(ProductDTO data){
        Product product = new Product();
        BeanUtils.copyProperties(data, product);
        return repository.save(product);
    }
}