package com.eComm.store.service.serviceImpl;

import com.eComm.store.model.CartItem;
import com.eComm.store.model.Product;
import com.eComm.store.repository.CartItemRepository;
import com.eComm.store.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;

    @Autowired
    CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public List<Product> getProductsInCart(UUID cartId) {
        List<CartItem> cartItems = cartItemRepository.findByCartID(cartId);

        return cartItems.stream()
                .map(CartItem::getProduct)
                .collect(Collectors.toList());
    }

}
