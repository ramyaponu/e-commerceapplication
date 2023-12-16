package com.example.webproject.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webproject.Exception.OrderException;
import com.example.webproject.dto.OrderDto;
import com.example.webproject.dto2.OrderProductDto;
import com.example.webproject.entity.OrderEntity;

import com.example.webproject.entity2.OrderProduct;
import com.example.webproject.repository.OrderRepository;
import com.example.webproject.repository2.ProductRepository;
@Service(value="orderservice")
public class OrderServiceImplimentation implements OrderService {
@Autowired
	private OrderRepository orderrepository;
@Autowired
  private ProductRepository productrepository;
	
@Override
public OrderEntity placeOrder(Integer productId) throws OrderException {
	
		
	List<OrderProduct> prod=productrepository.findAllByproductId(productId);
	if(prod!=null) {
		throw new OrderException("no products found");
	}
	OrderEntity order=new OrderEntity();
		order.setOrderProduct(prod);
		
		for(OrderProduct product : prod) {
			int currentquantity=product.getProductQuantity();
			
			if(currentquantity>0) {
				product.setProductQuantity(currentquantity-1);
			}else {
				throw new RuntimeException("product out of stock"+product.getProductName());
			}
		}
		order=orderrepository.save(prod);
		return order;
	}
@Override
   public OrderEntity viewOrder(Integer orderId) throws OrderException {
	 OrderEntity or=orderrepository.getOrderByOrderId(orderId);
	   
	return or;
	   
   }

public void placeOrder(OrderProduct orderpro) {
	
	OrderEntity order=new OrderEntity();
	order.setOrderDate(LocalDateTime.now());
	order.setOrderStatus("orderplaced");
	List<OrderProduct> or=new ArrayList<>();
	or.add(orderpro);
	order.setOrderProduct(or);
	orderrepository.save(order);
}

@Override
public void deleteOrder(Integer orderId) {
	orderrepository.deleteById(orderId);
	
}
@Override
public List<OrderEntity> findByOrderStatus(String orderStatus) {
	List<OrderEntity> oe=orderrepository.findByOrderStatus(orderStatus);
	return oe;
}
@Override
public List<OrderEntity> findByOrderStatusWithIndex(String orderStatus,LocalDateTime orderDate) {
	List<OrderEntity> oe=orderrepository.findByOrderStatusWithIndex(orderStatus, orderDate);
	return oe;
}
@Override
public List<OrderEntity> findByOrderId(Integer orderId) {
	List<OrderEntity> or=orderrepository.findByOrderId(orderId);
	return or;
}




}
