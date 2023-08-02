package com.cloudfy.ecommerce.ecseller.controllers.user;

import com.cloudfy.ecommerce.ecseller.services.user.DeleteSellerdService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/seller/delete")
public class DeleteSellerController {

    @Autowired
    private DeleteSellerdService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteSeller(id);
        return ResponseEntity.noContent().build();
    }
}