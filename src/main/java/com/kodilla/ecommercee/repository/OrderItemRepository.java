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
    List<OrderItem> findAll();
    Optional<OrderItem> findById(Long id);
    void deleteById(Long id);
    List<OrderItem> findAllByOrder_Id(Long orderId);
}
