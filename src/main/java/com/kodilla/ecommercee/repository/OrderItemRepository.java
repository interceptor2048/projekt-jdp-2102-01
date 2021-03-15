package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    OrderItem save(OrderItem orderItem);

    @Override
    List<OrderItem> findAll();

    @Override
    Optional<OrderItem> findById(Long id);

    @Override
    void deleteById(Long id);
}
