package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderItem;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class OrderItemDbServiceTest {

    @Autowired
    OrderItemDbService service;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    Verifier verifier;

    @Test
    public void testFindByOrderId() {
        //Given
        User user = new User("Wojtek");
        user.setUserKey(12345L);
        user.setAddress("Somewhere in the world");
        user.setEmail("SomeMail@mail");
        user.setPhoneNumber("118913");
        Product product1 = new Product("name of first product",
                "description of first product",
                100.0);
        Product product2 = new Product("name of second product",
                "description of second product",
                200.0);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        Order order = new Order();

        //When
        userRepository.save(user);
        productRepository.save(product1);
        productRepository.save(product2);
        order.setUser(user);
        List<OrderItem> orderItemList = productList.stream()
                .map(product -> new OrderItem(product,order)).collect(toList());
        orderItemList.add(new OrderItem(product1,order));
        order.setOrderItems(orderItemList);
        orderRepository.save(order);
        long orderId = order.getId();
        List<OrderItem> resultList = service.getOrderItemsByOrderId(orderId);
        verifier.verifyOrder(orderId);

        //Then
        assertEquals(3,resultList.size());
    }
}