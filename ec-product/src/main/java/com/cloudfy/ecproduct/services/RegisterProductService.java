package com.cloudfy.ecproduct.services;

import com.cloudfy.ecproduct.models.dto.ProductDTO;
import com.cloudfy.ecproduct.models.entities.Product;
import com.cloudfy.ecproduct.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterProductService {

    @Autowired
    private ProductRepository repository;

    public Product register(Product data){
        return repository.save(data);
    }

    public Product fromDTO(ProductDTO dataDTO){
        return new Product(dataDTO.getId(),dataDTO.getName(),dataDTO.getDescription(),dataDTO.getPrice(),dataDTO.getQuantity());
    }
}