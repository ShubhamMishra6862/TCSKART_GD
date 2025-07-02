package org.tcskart.productservice.service;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.tcskart.productservice.bean.Product;
import org.tcskart.productservice.dto.ProductRequestDTO;
import org.tcskart.productservice.dto.ProductResponseDTO;
import org.tcskart.productservice.repository.ProductRepository;
import org.tcskart.productservice.repository.RestockRepository;
import static org.junit.Assert.assertEquals;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private RestockRepository restockRepository;

    @Mock
    private EmailService emailService;

    @Test
    public void testAddProduct_success() {
        ProductRequestDTO dto = new ProductRequestDTO();
        dto.setName("Test Product");
        dto.setDescription("Test Description");
        dto.setPrice(BigDecimal.valueOf(100.0));
        dto.setQuantity(10);
        dto.setCategory("Test Category");
        dto.setImageUrl(List.of("test.jpg"));

        when(productRepository.findByName("Test Product")).thenReturn(Optional.empty());

        Product savedProduct = new Product();
        savedProduct.setId(1L);
        savedProduct.setName("Test Product");
        savedProduct.setDescription("Test Description");
        savedProduct.setPrice(BigDecimal.valueOf(100.0));
        savedProduct.setQuantity(10);
        savedProduct.setCategory("Test Category");
        savedProduct.setImageUrls(List.of("test.jpg"));

        when(productRepository.save(savedProduct)).thenReturn(savedProduct);

//        ProductResponseDTO response = productService.addProduct(savedProduct);

//        assertEquals("Test Product", response.getName());
    }
}
