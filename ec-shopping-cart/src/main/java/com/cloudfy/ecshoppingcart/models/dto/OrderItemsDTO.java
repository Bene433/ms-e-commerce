package com.cloudfy.ecshoppingcart.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsDTO {
    private Long id;
    private Long itemId;
    private Double price;
    private Integer quantity;
}