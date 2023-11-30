package com.eComm.store.service;

import com.eComm.store.model.CartItem;
import com.eComm.store.model.Product;
import com.eComm.store.service.serviceImpl.CartItemServiceImpl;

import java.util.List;
import java.util.UUID;

public interface CartItemService {
    List<Product> getProductsInCart(UUID cartId);
    void createCartItem(CartItem cartItem);

    void updateCartItem(UUID cartId, UUID productId, CartItem updatedCartItem);

    void deleteCartItem(UUID cartId, UUID productId);
}
