package com.products.apirest.repository;

import com.products.apirest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(long id);
}
