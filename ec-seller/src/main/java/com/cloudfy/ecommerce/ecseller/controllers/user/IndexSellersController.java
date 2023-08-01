package com.cloudfy.ecommerce.ecseller.controllers.user;

import com.cloudfy.ecommerce.ecseller.entities.Seller;
import com.cloudfy.ecommerce.ecseller.services.user.GetSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/sellers")
public class IndexSellersController {

    @Autowired
    private GetSellerService service;

    @GetMapping
    public ResponseEntity<List<Seller>> index(){
        List<Seller> list = service.index();
        return ResponseEntity.ok().body(list);
    }
}