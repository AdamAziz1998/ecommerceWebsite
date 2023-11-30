package com.eComm.store.service.serviceImpl;

import com.eComm.store.model.CartItem;
import com.eComm.store.model.Product;
import com.eComm.store.repository.CartItemRepository;
import com.eComm.store.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Override
    public void createCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public void updateCartItem(UUID cartId, UUID productId, CartItem updatedCartItem) {
        Optional<CartItem> optionalCartItem = Optional.ofNullable(cartItemRepository.findByCartIDAndProductID(cartId, productId));
        if (optionalCartItem.isPresent()) {
            CartItem existingCartItem = optionalCartItem.get();
            existingCartItem.setQuantity(updatedCartItem.getQuantity());

            cartItemRepository.save(existingCartItem);
        } else {
            // Handle the case where the cart item is not found
            // throw new YourCustomException("Cart item not found");
        }
    }

    @Override
    public void deleteCartItem(UUID cartId, UUID productId) {
        cartItemRepository.deleteByCartIDAndProductID(cartId, productId);
    }
}
