package com.example.webproject.repository2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webproject.dto2.OrderProductDto;
import com.example.webproject.entity2.OrderProduct;





public interface ProductRepository extends JpaRepository <OrderProduct,Integer>{

	OrderProduct findByProductName(String ProductName);

	

	List<OrderProduct> findAllByproductId(Integer productId);

	

}
