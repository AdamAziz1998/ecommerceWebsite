package com.eComm.store.service.serviceImpl;

import com.eComm.store.convert.CartConverter;
import com.eComm.store.convert.ProductConverter;
import com.eComm.store.dto.CartDTO;
import com.eComm.store.model.Cart;
import com.eComm.store.model.CartItem;
import com.eComm.store.model.Product;
import com.eComm.store.repository.CartRepository;
import com.eComm.store.repository.ProductRepository;
import com.eComm.store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    private final CartConverter cartConverter;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, CartConverter cartConverter) {
        this.cartRepository = cartRepository;
        this.cartConverter = cartConverter;
    }

    @Override
    public CartDTO createCart(CartDTO cart) {
        
        log.info("createCart started");

        Cart newCart = new Cart();

        newCart.setCartItems("{}");

        log.info("createProduct before save id: " + newCart.getId());

        newCart = cartRepository.save(newCart);

        log.info("createCart after save id: " + newCart.getId());

        return cartConverter.convertCartToCartDTO(newCart);
    }

    @Override
    public CartDTO deleteCart(UUID cartId) {
        
    }
}
