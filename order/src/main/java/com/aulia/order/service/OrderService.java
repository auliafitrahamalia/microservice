package com.aulia.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulia.order.model.Order;
import com.aulia.order.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getProkById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public Order creatOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrder (Long id){
        orderRepository.deleteById(id);
    }

}
