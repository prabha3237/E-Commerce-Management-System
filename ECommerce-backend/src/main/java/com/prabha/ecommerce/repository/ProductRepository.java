package com.prabha.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prabha.ecommerce.entity.Product;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

}