package com.eComm.store.dto;

import com.eComm.store.model.CartItem;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CartDTO {

    private UUID id;
    private List<CartItem> cartItems;
}
