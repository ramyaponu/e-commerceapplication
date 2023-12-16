package com.example.webproject.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webproject.entity.OrderEntity;
import com.example.webproject.entity2.OrderProduct;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

	OrderEntity getOrderByOrderId(Integer orderId);

	OrderEntity save(List<OrderProduct> prod);

	void save(OrderProduct orderpro);
	//JPQL named parameter
	@Query("select oe from OrderEntity oe where oe.orderStatus=:orderStatus")
	List<OrderEntity> findByOrderStatus(@Param("orderStatus")String orderStatus);
	
   //JPQL with index parameters
	@Query("select oe from OrderEntity oe where oe.orderStatus=?1 and oe.orderDate=?2")
	List<OrderEntity> findByOrderStatusWithIndex(String orderStatus,LocalDateTime orderDate);
	
	//SQL
	@Query(value="select * from ecommerce_application.Order_entity o where o.orderId=:orderId",nativeQuery=true)
	List<OrderEntity> findByOrderId(@Param ("orderId") Integer orderId);
	
}
