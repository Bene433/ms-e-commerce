package com.cloudfy.ecproduct.controllers;

import com.cloudfy.ecproduct.models.dto.ProductDTO;
import com.cloudfy.ecproduct.models.entities.Product;
import com.cloudfy.ecproduct.services.UpdateProductSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/product/update")
public class UpdateProductController {

    @Autowired
    private UpdateProductSerivce serivce;

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@RequestBody ProductDTO productDTO, @PathVariable Long id){
        Product product = serivce.fromDTO(productDTO);
        product.setId(id);
        serivce.update(product);
        return ResponseEntity.noContent().build();
    }
}