package com.eComm.store.service;

import com.eComm.store.dto.ProductDTO;
import com.eComm.store.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(UUID productId);

    List<ProductDTO> getProductsByCategory(String category);

    List<ProductDTO> getProductsBySearch(String searchTerm);

    ProductDTO createProduct(ProductDTO product);

    ProductDTO updateProduct(UUID productId, ProductDTO updateProduct);

    ProductDTO deleteProduct(UUID productId);
}
