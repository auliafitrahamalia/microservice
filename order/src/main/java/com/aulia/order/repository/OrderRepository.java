package com.aulia.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulia.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{


}
