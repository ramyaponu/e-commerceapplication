package com.example.webproject.service2;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webproject.Exception.OrderException;
import com.example.webproject.dto2.OrderProductDto;
import com.example.webproject.entity2.OrderProduct;
import com.example.webproject.repository2.ProductRepository;


@Service(value="ProductService")
@Transactional
public class ProductServiceImplementation implements ProductService {
  @Autowired   
private ProductRepository productrepository;
	
	public String addProducts(OrderProductDto dto) throws Exception {
		OrderProduct orprod=productrepository.findByProductName(dto.getProductName());
		if(orprod!=null) {
			throw new Exception("product is already added this name");
		}
		OrderProduct or=new OrderProduct();
		or.setProductId(dto.getProductId());
		or.setProductName(dto.getProductName());
		or.setProductCost(dto.getProductCost());
		or.setProductQuantity(dto.getProductQuantity());
		productrepository.save(or);
		return "product added successfully";
		
	}
	@Override
  public OrderProductDto viewProducts(Integer productId) throws OrderException {
		
	 Optional<OrderProduct> opt= productrepository.findById(productId);
	 OrderProduct product=opt.orElseThrow(()->new OrderException("product not found"));
	 OrderProductDto dto=new OrderProductDto();
	 dto.setProductId(product.getProductId());
	 dto.setProductName(product.getProductName());
	 dto.setProductCost(product.getProductCost());
	 dto.setProductQuantity(product.getProductQuantity());
	return dto;
	  
  }

	@Override
	public OrderProduct getProduct(String productName) throws OrderException {
		OrderProduct op=productrepository.findByProductName(productName);
			 
		return op;
		
	}
}
