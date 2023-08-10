package com.cloudfy.ecshoppingcart.services;

import com.cloudfy.ecshoppingcart.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteOrderService {

    @Autowired
    private OrderRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }
}