package com.eComm.store.service;

import com.eComm.store.dto.CartDTO;
import com.eComm.store.model.CartItem;

import java.util.UUID;

public interface CartService {
    CartDTO createCart(CartDTO cart);

    CartDTO deleteCart(UUID cartId);
}
