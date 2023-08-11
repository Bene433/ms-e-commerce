package com.cloudfy.ecoauth.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller{
    private Long id;
    private String name;
    private String email;
    private String sellerKey;
    private String password;
}