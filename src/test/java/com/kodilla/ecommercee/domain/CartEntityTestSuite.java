package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
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
public class CartEntityTestSuite {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCartEntityConnections() {

        //Given
        Product product1 = new Product(1L,
                "name of first product",
                "description of first product",
                100.0);

        Product product2 = new Product(2L,
                "name of second product",
                "description of second product",
                200.0);

        productRepository.save(product1);
        productRepository.save(product2);

        //When
        List<Product> productList = new ArrayList<>();
        productList.add(productRepository.findById(product1.getId()).get());
        productList.add(productRepository.findById(product2.getId()).get());

        User user = new User("Wojtek");
        user.setUserKey(12345L);
        user.setAddress("Somewhere in the world");
        user.setEmail("SomeMail@mail");
        user.setPhoneNumber("118913");

        Cart cart = new Cart(1L, user, productList);
        cartRepository.save(cart);

        //Then
        Cart resultCart = cartRepository.findAll().get(0);
        Product resultFirstProduct = resultCart.getProducts().get(0);
        Product resultSecondProduct = resultCart.getProducts().get(1);

        assertEquals("Wojtek",resultCart.getUser().getUserName());
        assertEquals(2,resultCart.getProducts().size());

        assertEquals("name of first product",resultFirstProduct.getProductName());
        assertEquals("description of second product",resultSecondProduct.getProductDescription());
        assertEquals(300.0, resultFirstProduct.getPrice()+resultSecondProduct.getPrice(),0);
    }

    @Test
    public void testFindById() {

        //Given
        User user = new User("Wojtek");
        user.setUserKey(12345L);
        user.setAddress("Somewhere in the world");
        user.setEmail("SomeMail@mail");
        user.setPhoneNumber("118913");
        Cart cart = new Cart(1L,user, new ArrayList<>());

        //When
        cartRepository.save(cart);
        long id = cartRepository.findAll().get(0).getId();

        //Then
        assertTrue(cartRepository.findById(id).isPresent());
    }

    @Test
    public void testDeleteById() {

        //Given
        User user = new User("Wojtek");
        user.setUserKey(12345L);
        user.setAddress("Somewhere in the world");
        user.setEmail("SomeMail@mail");
        user.setPhoneNumber("118913");
        Cart cart = new Cart(1L,user, new ArrayList<>());

        //When
        cartRepository.save(cart);
        long id = cartRepository.findAll().get(0).getId();
        cartRepository.deleteById(id);

        //Then
        assertFalse(cartRepository.findById(id).isPresent());
    }

}
