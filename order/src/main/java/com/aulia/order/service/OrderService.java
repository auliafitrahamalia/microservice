package com.aulia.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.aulia.order.model.Order;
import com.aulia.order.repository.OrderRepository;
import com.aulia.order.vo.Produk;
import com.aulia.order.vo.ResponseTemplate;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Order createOrder(Order order){
        Order savedOrder = orderRepository.save(order);
        System.out.println("ID dikirim: "+ savedOrder.getId());
        rabbitTemplate.convertAndSend("","order.notification.queue",savedOrder);
        return savedOrder;
    }

    @Transactional
    public void update(Long orderId, Integer jumlah, String status) {
        // Auto generated method s
        Order order = orderRepository.findById(orderId).orElseThrow(()
                -> new IllegalStateException("Order tidak ada"));
        if (jumlah != null) {
            order.setJumlah(jumlah);
        } 
    }
    

    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public List<ResponseTemplate> getOrderWithProdukById(Long id){
    List<ResponseTemplate> responseList = new ArrayList<>();

    Order order = getOrderById(id);
    if (order == null) {
        throw new RuntimeException("Order tidak ditemukan");
    }

    ServiceInstance serviceInstance = discoveryClient.getInstances("PRODUK").get(0);

    Produk produk = restTemplate.getForObject(
        serviceInstance.getUri() + "/api/produk/" + order.getId_produk(),
        Produk.class
    );

    ResponseTemplate vo = new ResponseTemplate();
    vo.setOrder(order);
    vo.setProduk(produk);

    responseList.add(vo);

    return responseList;
 }

    public void deleteOrder (Long id){
        orderRepository.deleteById(id);
    }

}