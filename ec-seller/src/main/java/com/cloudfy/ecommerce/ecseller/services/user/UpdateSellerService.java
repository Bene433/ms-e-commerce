package com.cloudfy.ecommerce.ecseller.services.user;

import com.cloudfy.ecommerce.ecseller.dto.SellerDTO;
import com.cloudfy.ecommerce.ecseller.entities.Seller;
import com.cloudfy.ecommerce.ecseller.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateSellerService {

    @Autowired
    private SellerRepository repository;

    public Seller update(Seller data){
        Seller sellerUpdated = findById(data.getId());
        updateData(sellerUpdated, data);
        return repository.save(sellerUpdated);

    }

    public void updateData(Seller sellerUpdated, Seller data){
        sellerUpdated.setName(data.getName());
        sellerUpdated.setEmail(data.getEmail());
        sellerUpdated.setSellerKey(data.getSellerKey());
        sellerUpdated.setPassword(data.getPassword());
    }

    public Seller findById(Long id){
        Seller seller = repository.findById(id).get();
        return seller;
    }

    public Seller fromDTO(SellerDTO sellerDTO){
        return new Seller(sellerDTO.getId(), sellerDTO.getName(), sellerDTO.getEmail(), sellerDTO.getSellerKey(), sellerDTO.getPassword());
    }
}