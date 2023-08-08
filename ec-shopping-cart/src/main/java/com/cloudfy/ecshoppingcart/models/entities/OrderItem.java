package com.cloudfy.ecshoppingcart.models.entities;

import com.cloudfy.ecshoppingcart.models.entities.pk.OrderItemPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;


    private OrderItemPk id = new OrderItemPk();
    private Integer quantity;
    private Double price;
}