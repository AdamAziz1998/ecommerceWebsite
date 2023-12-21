package com.eComm.store.service.serviceImpl;

import com.eComm.store.convert.ProductConverter;
import com.eComm.store.dto.ProductDTO;
import com.eComm.store.model.Product;
import com.eComm.store.repository.ProductRepository;
import com.eComm.store.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        log.info("getAllProducts started");
        List<Product> products = productRepository.findAll();
        log.info("getAllProducts len: " + products.size());

        return products.stream().map(productConverter::convertProductToProductDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(UUID productId) {
        log.info("getProductById started");
        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {
            return productConverter.convertProductToProductDTO(product);
        }

        return null;
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<ProductDTO> getProductsBySearch(String searchTerm) {
        return productRepository.findBySearchTerm(searchTerm);
    }

    //code below will be useful for the back office for this application

    @Override
    public void createProduct(ProductDTO product) {
        productRepository.save(product);
    }

    @Override
    public ProductDTO updateProduct(UUID productId, ProductDTO updatedProduct) {
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
