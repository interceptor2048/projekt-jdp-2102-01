package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Integer> {
    @Override
    List<Cart> findAll();

    @Override
     Cart save(Cart cart);

    @Query
    Optional<Cart> findById(Long id);

    @Query
    void deleteById(Long id);
}
