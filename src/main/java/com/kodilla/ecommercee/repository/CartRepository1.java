package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domian.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CartRepository1 extends CrudRepository<Cart,Long> {

    @Override
    List<Cart> findAll();

    @Override
    Optional<Cart> findById(Long id);

    List<Product>save(Product product);


    List<Product> getById();

    void deleteById(Long id);

    Order createNew(Cart cart);
}
