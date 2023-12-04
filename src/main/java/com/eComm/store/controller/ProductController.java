package com.eComm.store.controller;

import com.eComm.store.exception.ResourceNotFoundException;
import com.eComm.store.model.Product;
import com.eComm.store.repository.ProductRepository;
import com.eComm.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") UUID productId) {}

//    Product getProductById(UUID productId);
//
//    List<Product> getProductsByCategory(String category);
//
//    List<Product> getProductsBySearch(String searchTerm);
//
//    void createProduct(Product product);
//
//    void updateProduct(UUID productId, Product updateProduct);
//
//    void deleteProduct(UUID productId);
}
