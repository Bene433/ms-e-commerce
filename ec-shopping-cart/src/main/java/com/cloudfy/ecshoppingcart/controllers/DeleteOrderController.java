package com.cloudfy.ecshoppingcart.controllers;

import com.cloudfy.ecshoppingcart.services.DeleteOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(value = "/order/delete")
public class DeleteOrderController {

    @Autowired
    private DeleteOrderService service;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}