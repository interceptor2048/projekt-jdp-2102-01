package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domian.Product;
import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CartEntityTestSuite {

    @Autowired
    private CartRepository cartRepository;

    @Test
    @Transactional
    public void testCartEntityConnections() {

        //Given
        Product product1 = new Product(1L,
                "name of first product",
                "description of first product",
                100.0,
                new Group(1L,"First test group"));

        Product product2 = new Product(2L,
                "name of second product",
                "description of second product",
                200.0,
                new Group(2L,"Second test group"));

        //When
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        Cart cart = new Cart(productList);
        cartRepository.save(cart);

        //Then
        List<Cart> cartList = cartRepository.findAll();
        assertEquals(1,cartList.size());
    }
}
