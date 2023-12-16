package com.example.webproject.Service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.example.webproject.Exception.OrderException;
import com.example.webproject.dto.OrderDto;
import com.example.webproject.dto2.OrderProductDto;
import com.example.webproject.entity.OrderEntity;
import com.example.webproject.entity2.OrderProduct;

public interface OrderService {
   
	public OrderEntity  placeOrder(Integer ProductId)throws OrderException;
	public OrderEntity viewOrder(Integer orderId) throws OrderException;
	public void placeOrder(OrderProduct orderproduct);
	public void deleteOrder(Integer orderId);
	public List<OrderEntity> findByOrderStatus(String orderStatus);
	public List<OrderEntity> findByOrderStatusWithIndex(String orderStatus,LocalDateTime orderDate) ;
	List<OrderEntity> findByOrderId(Integer orderId);
	
}
