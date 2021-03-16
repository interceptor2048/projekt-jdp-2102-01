package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class UserEntityTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testUserEntityConnections() {
        //Given

        Product product1 = new Product(1L,
                "name of first product",
                "description of first product",
                100.0);

        Product product2 = new Product(2L,
                "name of second product",
                "description of second product",
                200.0);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        User user = new User("Wojtek");
        user.setUserKey(12345L);
        user.setAddress("Somewhere in the world");
        user.setEmail("SomeMail@mail");
        user.setPhoneNumber("118913");
        userRepository.save(user);

        Cart cart = new Cart(1L,user, productList);
        cartRepository.save(cart);

        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart);

        user.setCarts(cartList);

        User resultUser = userRepository.findAll().get(0);

        assertEquals(resultUser.getCarts().get(0).getProducts().get(0).getProductName(),"name of first product");
        assertEquals(resultUser.getUserName(),"Wojtek");
        assertEquals(resultUser.getCarts().size(),1);
        assertEquals(resultUser.getCarts().get(0).getProducts().size(),2);
        assertEquals(resultUser.getUserKey(),12345L,0);
    }

    @Test
    public void testFindById() {

        //Given
        User user = new User("Wojtek");
        user.setUserKey(12345L);
        user.setAddress("Somewhere in the world");
        user.setEmail("SomeMail@mail");
        user.setPhoneNumber("118913");
        userRepository.save(user);

        Cart cart = new Cart(1L,user, new ArrayList<>());
        cartRepository.save(cart);

        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart);

        user.setCarts(cartList);

        //When
        long id = userRepository.findAll().get(0).getId();

        //Then
        assertTrue(userRepository.findById(id).isPresent());
    }

    @Test
    public void testDeleteById() {

        //Given
        User user = new User("Wojtek");
        user.setUserKey(12345L);
        user.setAddress("Somewhere in the world");
        user.setEmail("SomeMail@mail");
        user.setPhoneNumber("118913");
        userRepository.save(user);

        Cart cart = new Cart(1L,user, new ArrayList<>());
        cartRepository.save(cart);

        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart);

        user.setCarts(cartList);

        //When
        long id = userRepository.findAll().get(0).getId();
        userRepository.deleteById(id);

        //Then
        assertFalse(userRepository.findById(id).isPresent());
    }
}
