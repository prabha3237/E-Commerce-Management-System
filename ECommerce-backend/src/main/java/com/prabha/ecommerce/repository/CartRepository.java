package com.prabha.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.prabha.ecommerce.entity.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUserId(Long userId);

    @Transactional
    void deleteAllByProduct_Id(Long productId);

}