package com.cloudfy.ecommerce.ecseller.services.user;

import com.cloudfy.ecommerce.ecseller.dto.SellerDTO;
import com.cloudfy.ecommerce.ecseller.entities.Seller;
import com.cloudfy.ecommerce.ecseller.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterSellerService {

    @Autowired
    private SellerRepository repository;

    public Seller register(Seller data){
        return repository.save(data);
    }

    public Seller fromDTO(SellerDTO dataDTO){
        return new Seller(dataDTO.getId(), dataDTO.getName(), dataDTO.getEmail(), dataDTO.getCellphone(), dataDTO.getPassword());
    }
}
