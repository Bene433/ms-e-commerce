package com.cloudfy.ecommerce.ecseller.controllers.user;

import com.cloudfy.ecommerce.ecseller.entities.Seller;
import com.cloudfy.ecommerce.ecseller.services.user.GetSellerByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/seller")
public class GetSellerByIdController {

    @Autowired
    private GetSellerByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id){
        Seller seller = service.getSellerById(id);
        return ResponseEntity.ok().body(seller);
    }
}