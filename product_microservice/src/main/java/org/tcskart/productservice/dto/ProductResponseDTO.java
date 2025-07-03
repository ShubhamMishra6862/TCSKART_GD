package org.tcskart.productservice.dto;

import java.math.BigDecimal;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> f727ad051dce19faee223c367541c9bfa24cdc32

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {
	private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String category;
<<<<<<< HEAD
    private List<String> imageUrl;
=======
    private String imageUrl;
>>>>>>> f727ad051dce19faee223c367541c9bfa24cdc32
}
