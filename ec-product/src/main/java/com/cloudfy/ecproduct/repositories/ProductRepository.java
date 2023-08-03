package com.cloudfy.ecproduct.repositories;

import com.cloudfy.ecproduct.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}