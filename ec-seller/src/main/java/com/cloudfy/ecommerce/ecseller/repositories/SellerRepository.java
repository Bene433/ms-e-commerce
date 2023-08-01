package com.cloudfy.ecommerce.ecseller.repositories;

import com.cloudfy.ecommerce.ecseller.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {}