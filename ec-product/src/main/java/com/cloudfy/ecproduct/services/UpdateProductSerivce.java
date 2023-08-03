package com.cloudfy.ecproduct.services;

import com.cloudfy.ecproduct.models.dto.ProductDTO;
import com.cloudfy.ecproduct.models.entities.Product;
import com.cloudfy.ecproduct.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductSerivce {

    @Autowired
    private ProductRepository repository;

    public Product update(Product data){
        Product productUpdated = findById(data.getId());
        updateData(productUpdated, data);
        return repository.save(productUpdated);
    }

    public void updateData(Product productUpdated, Product productFromDataBase){
        productUpdated.setName(productFromDataBase.getName());
        productUpdated.setDescription(productFromDataBase.getDescription());
        productUpdated.setPrice(productFromDataBase.getPrice());
        productUpdated.setQuantity(productFromDataBase.getQuantity());
    }

    public Product findById(Long id){
        Product product = repository.findById(id).get();
        return product;
    }

    public Product fromDTO(ProductDTO productDTO){
        return new Product(productDTO.getId(), productDTO.getName(),productDTO.getDescription(),productDTO.getPrice(),productDTO.getQuantity());
    }
}