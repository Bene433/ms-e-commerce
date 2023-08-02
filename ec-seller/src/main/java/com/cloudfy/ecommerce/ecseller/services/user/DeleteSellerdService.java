package com.cloudfy.ecommerce.ecseller.services.user;

import com.cloudfy.ecommerce.ecseller.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteSellerdService {

    @Autowired
    private SellerRepository repository;

    public void deleteSeller(Long id){
        repository.deleteById(id);
    }
}