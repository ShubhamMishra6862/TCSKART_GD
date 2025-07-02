package org.tcskart.order.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tcskart.order.beans.Order;
import org.tcskart.order.beans.OrderItem;
import org.tcskart.order.dto.CartItemDTO;
import org.tcskart.order.repository.OrderItemRepository;
import org.tcskart.order.repository.OrderRepository;


@Service
public class OrderServiceImplimentation implements OrderService{
	
	@Autowired
	private OrderRepository repo;
	@Autowired
	private OrderItemRepository repoItem;
	
	@Autowired
	EmailService eservice;

	@Override
	public List<OrderItem> getAllOrdersByUserId(Long userId) {
		List<OrderItem> orderItems=repoItem.findall(userId);
		return orderItems;
		
	}
	

	
	@Override
	public List<String> trackOrderStatus(Long userId) {
	    List<Order> userOrders = repo.findByUserId(userId);
	    List<String> statusList = new ArrayList<>();

	    for (Order order : userOrders) {
	        LocalDateTime orderTime = order.getOrderDate();
	        LocalDateTime now = LocalDateTime.now();
	        Duration duration = Duration.between(orderTime, now);
	        long minutesPassed = duration.toMinutes();

	        String dynamicStatus;

	        if (minutesPassed < 2) {
	            dynamicStatus = "PENDING";
	        } else if (minutesPassed < 5) {
	            dynamicStatus = "SHIPPED";
	        } else {
	            dynamicStatus = "DELIVERED";
	        }

	        String status = "Order ID: " + order.getOrderId() +
	                        ", Status: " + dynamicStatus +
	                        ", Date: " + orderTime +
	                        ", Total Amount: ₹" + order.getTotalAmount();
	        statusList.add(status);
	    }

	    return statusList;
	}

	
	@Override
	public Order placeOrder(Long userId) {
		
	    List<CartItemDTO> cartItemList = new ArrayList<>();
	    cartItemList.add(new CartItemDTO(29, 29, 40000));
	    cartItemList.add(new CartItemDTO(68, 150, 4900));
	    cartItemList.add(new CartItemDTO(38, 50, 1780));
	    
	    Order savedOrder = null;

	    for (CartItemDTO cartItemDTO : cartItemList) {
	        Order order = new Order();
	        int userid = 22;
	        order.setUserId(userId);
	        order.setOrderstatus("PLACED");
	        order.setPaymentMode("CashOnDelivery");
	        order.setOrderDate(LocalDateTime.now());

	        savedOrder = repo.save(order);

	        OrderItem item = new OrderItem();
	        item.setProductId(cartItemDTO.getProductId());
	        item.setQuantity(cartItemDTO.getQuantity());
	        item.setAmount(cartItemDTO.getAmount());
	        item.setOrder(savedOrder); // 🔁 now each item gets its own order
	        repoItem.save(item);

	        savedOrder.setTotalAmount(cartItemDTO.getAmount().longValue());
	        repo.save(savedOrder); // update total
	    }

	    eservice.sendSimpleEmail("nandanp016@gmail.com", "Orders placed successfully", "Your orders have been placed");
		return repo.save(savedOrder);
	  
	}

	

}

