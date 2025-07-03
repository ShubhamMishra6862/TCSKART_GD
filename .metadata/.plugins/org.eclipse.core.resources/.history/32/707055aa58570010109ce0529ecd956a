package org.tcskart.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tcskart.productservice.dto.ProductRequestDTO;
import org.tcskart.productservice.dto.ProductResponseDTO;
import org.tcskart.productservice.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Add product (Admin)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/products")
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody @Valid ProductRequestDTO requestDTO) {
        ProductResponseDTO responseDTO = productService.addProduct(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    // Get all products
    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String search) {

        List<ProductResponseDTO> products = productService.getAllProducts(page, size, category, search);
        return ResponseEntity.ok(products);
    }


    // Get product by ID
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    
    @GetMapping("/products/all")
    public List<ProductResponseDTO> getAllProducts() {
    	return productService.getAllProducts();
    }
}

