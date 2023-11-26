package com.eComm.store.repository;

import com.eComm.store.model.Cart;
import com.eComm.store.model.CartItem;
import com.eComm.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {
    List<CartItem> findB
}
