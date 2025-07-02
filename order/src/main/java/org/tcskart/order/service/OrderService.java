package org.tcskart.order.service;

import java.util.List;

import org.tcskart.order.beans.Order;
import org.tcskart.order.beans.OrderItem;



public interface OrderService {
	
	Order placeOrder(Long userId );
	
	 List<OrderItem> getAllOrdersByUserId(Long userId);
	 
	 List<String> trackOrderStatus(Long userId);


}
