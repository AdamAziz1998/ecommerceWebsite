package com.eComm.store.service;

import com.eComm.store.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(UUID productId);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsBySearch(String searchTerm);

    void saveProduct(Product product);

    void updateProduct(UUID productId, Product updateProduct);

    void deleteProduct(UUID productId);
}
