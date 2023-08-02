package com.cloudfy.ecommerce.ecseller.controllers.user;

import com.cloudfy.ecommerce.ecseller.dto.SellerDTO;
import com.cloudfy.ecommerce.ecseller.entities.Seller;
import com.cloudfy.ecommerce.ecseller.services.user.UpdateSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RestController
@RequestMapping(value = "/seller/update")
public class UpdateSellerController {

    @Autowired
    private UpdateSellerService service;

    @PutMapping(value = "/{id}")
    public ResponseEntity<Seller> update(@RequestBody SellerDTO sellerDTO, @PathVariable Long id){
        Seller seller = service.fromDTO(sellerDTO);
        seller.setId(id);
        seller = service.update(seller);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(seller.getId()).toUri();
        return ResponseEntity.noContent().build();
    }
}