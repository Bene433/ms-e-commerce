package com.cloudfy.ecshoppingcart.models.entities.pk;

import com.cloudfy.ecshoppingcart.models.entities.Order;
import com.cloudfy.ecshoppingcart.models.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

public class OrderItemPk implements Serializable {
    private static final long serialVersionUID = 1L;
    private Order order;
    private Product product;
}