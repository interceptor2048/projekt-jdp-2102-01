package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderItemRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.service.ProductDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class OrderItemsEntityTestSuite {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDbService productDbService;
    @Autowired
    OrderItemRepository orderItemRepository;

    @Test
    public void testAddItemToTheOrder() {
        Product product1 = new Product(1234L, "Product 1", "Normal Product", 2.5);
        Product product2 = new Product(234456L, "Product 2", "Premium Product", 3.2);
        productRepository.save(product1);
        productRepository.save(product2);

        //When
        OrderItems orderItems1 = new OrderItems();
        orderItemRepository.save(orderItems1);
        OrderItems orderItems2 = new OrderItems();
        orderItemRepository.save(orderItems2);

        Product resultProduct1 = orderItemRepository.findAll().get(0).getProduct();
        Product resultProduct2 = orderItemRepository.findAll().get(1).getProduct();

        //Then
        assertEquals(product1.getProductName(), "Product 1");
        assertEquals("Product 2", product2.getProductName());

        orderItemRepository.deleteAll();

    }

    @Test
    public void testSaveOrderItem() {
        //Given
        OrderItems orderItem = new OrderItems();

        //When
        orderItemRepository.save(orderItem);

        //Then
        Long id = orderItem.getId();
        Optional<OrderItems> findOrderItem = orderItemRepository.findById(id);
        assertTrue(findOrderItem.isPresent());

        //CleanUp
        orderItemRepository.deleteAll();
    }

    @Test
    public void testFindAllOrderItems() {
        //Given
        OrderItems orderItem1 = new OrderItems();
        OrderItems orderItem2 = new OrderItems();
        OrderItems orderItem3 = new OrderItems();
        OrderItems orderItem4 = new OrderItems();
        OrderItems orderItem5 = new OrderItems();

        //When
        orderItemRepository.save(orderItem1);
        orderItemRepository.save(orderItem2);
        orderItemRepository.save(orderItem3);
        orderItemRepository.save(orderItem4);
        orderItemRepository.save(orderItem5);
        List<OrderItems> orderItemsList = orderItemRepository.findAll();

        //Then
        assertEquals(5, orderItemsList.size());

        //CleanUp
        orderItemRepository.deleteAll();
    }

    @Test
    public void testFindOrderItemById() {
        //Given
        OrderItems orderItem = new OrderItems();

        //When
        orderItemRepository.save(orderItem);
        Long orderItemId = orderItem.getId();

        //Then
        assertEquals(orderItem.getId(), orderItemRepository.findById(orderItemId).get().getId());

        //CleanUp
        orderItemRepository.deleteAll();
    }

}
