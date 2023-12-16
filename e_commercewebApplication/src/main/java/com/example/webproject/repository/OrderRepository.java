package com.example.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webproject.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

	OrderEntity getOrderByOrderId(Integer orderId);

}
