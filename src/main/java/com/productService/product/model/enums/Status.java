package com.productService.product.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {inStock, outOfStock, oneLeftInStock, almostSoldOut}
