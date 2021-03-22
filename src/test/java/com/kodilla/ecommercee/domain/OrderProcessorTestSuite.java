package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.processor.OrderProcessor;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.verify;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class OrderProcessorTestSuite {
    @Autowired
    OrderProcessor processor;

    @Autowired
    UserRepository repository;


    @Test
    public void testVerifyOrder(){
        //GIVEN
        Order order = new Order();

        //WHEN
        processor.verifyOrder(order);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(order.getUser().getEmail());

        //THEN
        assertTrue(order.isVerified());
        assertEquals(mailMessage.getTo(), order.getUser().getEmail());
    }

    @Test
    public void testPayOrder (){
//GIVEN
        Order order = new Order();

        //WHEN
        processor.verifyOrder(order);

        //THEN
        assertTrue(order.isPaid());

    }

    @Test
    public void testSendOrder (){
        //GIVEN
        Order order = new Order();

        //WHEN
        processor.verifyOrder(order);

        //THEN
        assertTrue(order.isSent());
    }

    @Test
    public void testRemoveUsers (){
        //GIVEN
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        repository.save(user1);
        repository.save(user2);
        repository.save(user3);

        //WHEN
        processor.removeUsers(user2);
        int size = repository.findAll().size();

        //THEN
        assertEquals(size, 2);
    }
}
