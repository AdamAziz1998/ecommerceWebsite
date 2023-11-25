package com.eComm.store.repository;

import com.eComm.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByCategory(String category);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Product> findBySearchTerm(@Param("searchTerm") String searchTerm);
}
