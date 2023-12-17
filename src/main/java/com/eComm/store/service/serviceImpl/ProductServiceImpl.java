package com.eComm.store.service.serviceImpl;

import com.eComm.store.dto.ProductDTO;
import com.eComm.store.model.Product;
import com.eComm.store.repository.ProductRepository;
import com.eComm.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(UUID productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getProductsBySearch(String searchTerm) {
        return productRepository.findBySearchTerm(searchTerm);
    }

    //code below will be useful for the back office for this application

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product updateProduct(UUID productId, Product updatedProduct) {
        Product product = productRepository.findById(productId).orElse(null);

        if (product == null) {
            return null;
        }

        product.setName(updatedProduct.getName());
        product.setStatus(updatedProduct.getStatus());
        product.setPrice(updatedProduct.getPrice());
        product.setStockQuantity(updatedProduct.getStockQuantity());
        product.setImageUrl(updatedProduct.getImageUrl());
        product.setDescription(updatedProduct.getDescription());
        product.setCategory(updatedProduct.getCategory());

        productRepository.save(product);

        return product;
    }

    @Override
    public void deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
    }
}
