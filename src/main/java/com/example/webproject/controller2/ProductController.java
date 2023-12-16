package com.example.webproject.controller2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webproject.Exception.OrderException;
import com.example.webproject.dto2.OrderProductDto;
import com.example.webproject.entity2.OrderProduct;
import com.example.webproject.service2.ProductServiceImplementation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@RestController
 @RequestMapping(value="/products")
 public class ProductController {
	@Autowired
	private ProductServiceImplementation productserviceimpl;
	
	@PostMapping(value="/add-product")
	public String addProducts(@RequestBody OrderProductDto dto) throws Exception {
    productserviceimpl.addProducts(dto);
    
    return "products added successfully";		
	}
	@GetMapping(value="/view-product/productId/{productId}")
	public ResponseEntity<OrderProductDto> viewProduct(@Valid @Min(value=1,message="product is not in a range") @Max(value=99999,message="productid is not in a range")@PathVariable Integer productId) throws Exception{
		OrderProductDto dto=productserviceimpl.viewProducts(productId);
		
		return new ResponseEntity<OrderProductDto>(dto,HttpStatus.OK);
		
	}
	@RequestMapping(value="/get-product/productName/{productName}",method=RequestMethod.GET)
	public OrderProduct getProduct(@Pattern(regexp = "[a-zA-Z]+", message = "please provide a valid name")@PathVariable ("productName") String ProductName) throws Exception {
		
		OrderProduct op=productserviceimpl.getProduct(ProductName);
		return op;
		
	}
	

}
