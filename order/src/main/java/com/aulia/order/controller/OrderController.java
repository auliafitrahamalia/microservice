package com.aulia.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aulia.order.model.Order;
import com.aulia.order.service.OrderService;
import com.aulia.order.vo.ResponseTemplate;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        Order order = orderService.getOrderById(id);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public Order creatOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @GetMapping(path = "/produk{id}")
    public List<ResponseTemplate> getOrderWithProdukById(@PathVariable("id") long id){
        return orderService.getOrderWithProdukById(id);
    }

    @PutMapping(path = "{id}")
    public void updateOrder(@PathVariable("id")long id,
            @RequestParam(required = false) int jumlah,
            @RequestParam(required = false) String status){
                orderService.update(id, jumlah, status);
            }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder (@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

}
