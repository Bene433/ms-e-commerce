package com.cloudfy.ecommerce.ecseller.services.user;

import com.cloudfy.ecommerce.ecseller.entities.Seller;
import com.cloudfy.ecommerce.ecseller.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSellerByIdService {

    @Autowired
    private SellerRepository repository;

    public Seller getSellerById(Long id){
        Seller seller = repository.findById(id).get();
        return seller;
    }
}