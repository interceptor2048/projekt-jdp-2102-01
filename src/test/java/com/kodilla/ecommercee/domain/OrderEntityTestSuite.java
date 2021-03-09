package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class OrderEntityTestSuite {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testOrderConnections() {
        //Given
        User user1 = new User(1L, "User1", true, 1234L);
        User user2 = new User(2L, "User2", false, 2345L);
        userRepository.save(user1);
        userRepository.save(user2);

        //When
        Order order1 = new Order(111L, user2, true, true, true);
        Order order2 = new Order(222L, user1, true, true, true);
        orderRepository.save(order1);
        orderRepository.save(order2);

        //Then
        User resultUser1 = orderRepository.findAll().get(0).getUser();
        User resultUser2 = orderRepository.findAll().get(1).getUser();

        assertEquals("User1", resultUser2.getUserName());
        assertEquals(resultUser1.getUserKey(), user2.getUserKey());

        //CleanUp
        orderRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void testSaveOrder() {
        //Given
        Order order = new Order();

        //When
        orderRepository.save(order);

        //Then
        Long id = order.getId();
        Optional<Order> readOrder = orderRepository.findById(id);
        assertTrue(readOrder.isPresent());

        //CleanUp
        orderRepository.deleteAll();
    }

    @Test
    public void testFindOrderById() {
        //Given
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        //When
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);
        Long id = order3.getId();
        Optional<Order> readOrder = orderRepository.findById(id);

        //Then
        assertEquals(order3.getId(), orderRepository.findById(id).get().getId());

        //CleanUp
        orderRepository.deleteAll();
        }

    @Test
    public void testOrderFindAll() {
        //Given
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        //When
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);
        List<Order> orders = orderRepository.findAll();

        //Then
        assertEquals(4, orders.size());
        assertNotEquals(2, orders.size());

        //CleanUp
        orderRepository.deleteAll();
    }
}
