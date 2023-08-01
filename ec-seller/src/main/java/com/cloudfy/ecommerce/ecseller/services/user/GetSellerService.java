package com.cloudfy.ecommerce.ecseller.services.user;

import com.cloudfy.ecommerce.ecseller.entities.Seller;
import com.cloudfy.ecommerce.ecseller.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSellerService {

    @Autowired
    private SellerRepository repository;

    public List<Seller> index(){
        List<Seller> sellers = repository.findAll();
        return sellers;
    }
}