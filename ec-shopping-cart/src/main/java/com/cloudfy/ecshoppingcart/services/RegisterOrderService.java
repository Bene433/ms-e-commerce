package com.cloudfy.ecshoppingcart.services;

import com.cloudfy.ecshoppingcart.controllers.GetCustomerController;
import com.cloudfy.ecshoppingcart.controllers.GetProductController;
import com.cloudfy.ecshoppingcart.models.dto.OrderItemsDTO;
import com.cloudfy.ecshoppingcart.models.dto.OrderRequest;
import com.cloudfy.ecshoppingcart.models.entities.Customer;
import com.cloudfy.ecshoppingcart.models.entities.Order;
import com.cloudfy.ecshoppingcart.models.entities.OrderItems;
import com.cloudfy.ecshoppingcart.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterOrderService {

    @Autowired
    private GetCustomerController getCustomerController;

    @Autowired
    private GetProductController getProductController;

    @Autowired
    private OrderRepository repository;

    public Order registerOrder(OrderRequest orderRequest){
        Order order = new Order();
        Customer customer = getCustomerController.getCustomer(orderRequest.getCustomerId());
        List<OrderItems> orderItems = orderRequest.getOrderItemsDto().stream().map(this::mapToDTO).toList();

        order.setCustomer(customer);
        order.setItems(orderItems);
        return repository.save(order);
    }

    private OrderItems mapToDTO(OrderItemsDTO orderItemsDTO){
        OrderItems orderItems = new OrderItems();
        orderItems.setProduct(getProductController.getProduct(orderItemsDTO.getProductId()));
        orderItems.setQuantity(orderItemsDTO.getQuantity());
        return orderItems;
    }

}