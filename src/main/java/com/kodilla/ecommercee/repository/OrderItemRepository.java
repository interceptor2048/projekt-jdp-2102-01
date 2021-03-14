package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.OrderItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface OrderItemRepository extends CrudRepository<OrderItems, Long> {

    OrderItems save(OrderItems orderItems);

    @Override
    List<OrderItems> findAll();

    @Override
    Optional<OrderItems> findById(Long id);

    @Override
    void deleteById(Long id);
}
