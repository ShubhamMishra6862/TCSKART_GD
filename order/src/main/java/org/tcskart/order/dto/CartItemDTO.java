package org.tcskart.order.dto;


import lombok.Data;

@Data
public class CartItemDTO {

	    private Integer productId;
	    private Integer quantity;
	    private Integer amount;
		public CartItemDTO(Integer productId, Integer quantity, Integer amount) {
//			super();
			this.productId = productId;
			this.quantity = quantity;
			this.amount = amount;
		}
	}


