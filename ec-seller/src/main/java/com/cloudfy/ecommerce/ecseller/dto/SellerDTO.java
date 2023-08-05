package com.cloudfy.ecommerce.ecseller.dto;

import java.io.Serializable;

public class SellerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private String sellerKey;
    private String password;

    public SellerDTO() {}

    public SellerDTO(Long id, String name, String email, String sellerKey, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sellerKey = sellerKey;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getsellerKey() {
        return sellerKey;
    }

    public void setsellerKey(String sellerKey) {
        this.sellerKey = sellerKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}