package com.example.webproject.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webproject.Exception.OrderException;
import com.example.webproject.Service.OrderService;
import com.example.webproject.Service.OrderServiceImplimentation;
import com.example.webproject.dto.OrderDto;
import com.example.webproject.dto2.OrderProductDto;
import com.example.webproject.entity.OrderEntity;
import com.example.webproject.entity2.OrderProduct;
import com.example.webproject.repository.OrderRepository;

@RestController
@RequestMapping(value="/orders")
public class OrderController {
   @Autowired
   private OrderServiceImplimentation orderserviceimpl;
  
  
   @RequestMapping(value="/vieworder/orderId/{orderId}",method=RequestMethod.GET)
   public OrderEntity viewOrderDetails(@PathVariable Integer orderId) throws Exception {
	   OrderEntity or=orderserviceimpl.viewOrder(orderId);
	return or;
	   
   }
   @PostMapping(value = "/place-order")
   public void placeOrder(@RequestBody OrderProduct input) {
	   orderserviceimpl.placeOrder(input);
   }
   @DeleteMapping(value = "/delete-order/orderId/{orderId}")
   public String deleteOrder(@PathVariable Integer orderId) throws Exception {
    	   orderserviceimpl.deleteOrder(orderId);
    	   
		return "orderdeleted successfully";
    	   
       }
   @GetMapping(value="/get-order/orderStatus/{orderStatus}")
   public List<OrderEntity> findByOrderStatus(@PathVariable String orderStatus) {
	  List<OrderEntity> oe= orderserviceimpl.findByOrderStatus(orderStatus);
	return oe;
	   
   }
   @GetMapping(value="/get-order/orderStatus/{orderStatus}/orderDate/{orderDate}")
   public List<OrderEntity> findByOrderStatusWithIndex(@PathVariable ("orderStatus")  String orderStatus,@PathVariable ("orderStatus") LocalDateTime orderDate){
	   List<OrderEntity> oe=orderserviceimpl.findByOrderStatusWithIndex(orderStatus, orderDate);
	   return oe;
	   
   }
   @GetMapping(value="get-order/orderId/{orderId}")
   public List<OrderEntity> findByOrderId(@PathVariable ("orderId")Integer orderId) {
		List<OrderEntity> or=orderserviceimpl.findByOrderId(orderId);
		return or;
	} 
}
