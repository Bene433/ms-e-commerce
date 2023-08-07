package com.cloudfy.ecommerce.ecseller.controllers.user;

import com.cloudfy.ecommerce.ecseller.dto.SellerDTO;
import com.cloudfy.ecommerce.ecseller.entities.Seller;
import com.cloudfy.ecommerce.ecseller.services.user.RegisterSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RestController
@RequestMapping(value = "/seller/register")
public class RegisterSellerController {

    @Autowired
    private RegisterSellerService service;

    @PostMapping
    public ResponseEntity<Seller> registerSeller(@RequestBody SellerDTO dataDTO){
        Seller seller = service.register(dataDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(seller.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}