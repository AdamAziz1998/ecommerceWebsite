package com.productService.product.convert;

import com.productService.product.dto.ProductDTO;
import com.productService.product.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    private final ModelMapper modelMapper;

    public ProductConverter (ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDTO convertProductToProductDTO (Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product convertProductDTOToProduct (ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
