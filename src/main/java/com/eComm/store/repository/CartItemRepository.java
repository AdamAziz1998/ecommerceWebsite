package com.eComm.store.repository;

import com.eComm.store.model.CartItem;
import com.eComm.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
    List<CartItem> findByCartID(UUID cartId);

    CartItem findByCartIDAndProductID(UUID cartId, UUID productId);

    void deleteByCartIDAndProductID(UUID cartId, UUID productId);
}
