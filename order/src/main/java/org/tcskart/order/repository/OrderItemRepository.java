package org.tcskart.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tcskart.order.beans.OrderItem;



public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
//List<OrderItem> findByOrder_userId(Long userid );
	
	@Query("select oi from OrderItem oi where oi.order.userId=:userId")
	List<OrderItem> findall(@Param("userId")Long userId);
}
