package com.eComm.store.service.serviceImpl;

import com.eComm.store.model.CartItem;
import com.eComm.store.model.Product;
import com.eComm.store.repository.CartRepository;
import com.eComm.store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
}
