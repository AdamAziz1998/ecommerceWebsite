package com.eComm.store.model;

import com.eComm.store.model.enums.Category;
import com.eComm.store.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "status", columnDefinition = "integer")
    private Status status;

    @NotNull
    @Positive
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @NotNull
    @PositiveOrZero
    @Column(name = "stockQuantity")
    private int stockQuantity;

    @NotNull
    @Column(name = "imageUrl")
    private String imageUrl;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "category", columnDefinition = "integer")
    private Category category;
}
