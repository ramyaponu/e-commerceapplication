package com.example.webproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
   @RequestMapping(value = "/place-order/productId/{productId}", method = RequestMethod.POST)
   public String placeOrder(@PathVariable Integer productId) throws Exception {
    	   orderserviceimpl.placeOrder(productId);
		return "orderPlaced successfully";
    	   
       }
   @RequestMapping(value="/vieworder/productId/{productId}",method=RequestMethod.GET)
   public OrderEntity viewOrderDetails(@PathVariable Integer orderId) throws Exception {
	   OrderEntity or=orderserviceimpl.viewOrder(orderId);
	return or;
	   
   }
   
}
