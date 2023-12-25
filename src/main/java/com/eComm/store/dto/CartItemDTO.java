package com.eComm.store.dto;

import com.eComm.store.model.Cart;
import com.eComm.store.model.Product;
import lombok.Data;

import java.util.UUID;

@Data
public class CartItemDTO {

    private UUID id;
    private Cart cart;
    private Product product;
    private int quantity;
}
