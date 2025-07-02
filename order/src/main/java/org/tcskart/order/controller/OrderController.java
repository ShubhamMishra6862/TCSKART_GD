package org.tcskart.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tcskart.order.beans.Order;
import org.tcskart.order.beans.OrderItem;
import org.tcskart.order.service.OrderService;


@RestController
@RequestMapping("orders")
public class OrderController {
	
	
//	 @Autowired
//	    private OrderService orderService;
	@Autowired
	private OrderService orderService;
	   
	        @PostMapping("/place/{userId}")
	        public void placeOrder(@PathVariable Long userId) {
	            orderService.placeOrder(userId);
	        }
	        

	        @GetMapping("/user/{userId}")
	        public List<OrderItem> getOrdersByUserId(@PathVariable Long userId) {
	            return orderService.getAllOrdersByUserId(userId); 
	        }
	        
	        
	        @GetMapping("/status/{userId}")
	        public List<String> getOrderStatusByUser(@PathVariable Long userId) {
	            return orderService.trackOrderStatus(userId);
	        }

}
