package com.eComm.store.dto;

import com.eComm.store.model.enums.Category;
import com.eComm.store.model.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductDTO {

    private UUID id;
    private String name;
    private Status status;
    private BigDecimal price;
    private int stockQuantity;
    private String description;
    private String imageUrl;
    private String category;
}
