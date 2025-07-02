package org.tcskart.order.repository;

import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.tcskart.order.beans.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tcskart.order.beans.Order;



public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	public List<Order> findByUserId(Long userId);
	
	List<Order> findAllByUserId(Long userId); 
	
//	List<Order> findByUserId(Long userId);


}



