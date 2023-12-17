package com.eComm.store.controller;

import com.eComm.store.dto.ProductDTO;
import com.eComm.store.model.Product;
import com.eComm.store.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@Tag(name="Products API")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    @Operation(summary = "Retrieve All Products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found zero or more Products",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class))) }),
            @ApiResponse(responseCode = "403", description = "Authorization Failed",
                    content = @Content) })
    public ResponseEntity<?> getAllProducts() {

        log.info("getAllProducts started");

        List<ProductDTO> products = productService.getAllProducts();

        return ResponseEntity.status(HttpStatus.OK).body(products);


    }

    @GetMapping("products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(value = "id") UUID productId) {
        return productService.getProductById(productId);
    }

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
