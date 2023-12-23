package com.eComm.store.controller;

import com.eComm.store.dto.ProductDTO;
import com.eComm.store.model.Product;
import com.eComm.store.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//TODO: Add some security to the project, and some permission for more admin related roles, when the user service is created

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

        log.info("getProducts started");

        List<ProductDTO> products = productService.getAllProducts();

        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/products/{id}")
    @Operation(summary = "Retrieve Product by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Product matching this Id",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Product Not Found",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Authorization Failed",
                    content = @Content) })
    public ResponseEntity<?> getProductById(@Parameter(description = "id of Product to be found") @PathVariable UUID id) {

        log.info("getProductById started");

        ProductDTO productDTO = productService.getProductById(id);

        if (productDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(productDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{}");
        }
    }

    @GetMapping("/productsByCategory/{category}")
    @Operation(summary = "Retrieve Products by Category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found zero or more Products",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class))) }),
            @ApiResponse(responseCode = "403", description = "Authorization Failed",
                    content = @Content) })
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@Parameter(description = "Category of the products to be found") @PathVariable String category) {

        log.info("getProductsByCategory started");

        List<ProductDTO> productDTOList = productService.getProductsByCategory(category);

        return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
    }

    @GetMapping("/productsBySearch/{searchTerm}")
    @Operation(summary = "Retrieve Products by Category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found zero or more Products",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class))) }),
            @ApiResponse(responseCode = "403", description = "Authorization Failed",
                    content = @Content) })
    public ResponseEntity<List<ProductDTO>> getProductsBySearch(@Parameter(description = "Products found by search term") @PathVariable String searchTerm) {

        log.info("getProductsBySearch started");

        List<ProductDTO> productDTOList = productService.getProductsBySearch(searchTerm);

        return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
    }




//    void createProduct(Product product);
//    void updateProduct(UUID productId, Product updateProduct);
//    void deleteProduct(UUID productId);
}
