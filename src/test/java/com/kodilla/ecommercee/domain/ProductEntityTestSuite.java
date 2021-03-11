package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.controller.exceptions.ProductConflictException;
import com.kodilla.ecommercee.service.GroupDbService;
import com.kodilla.ecommercee.service.ProductDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class ProductEntityTestSuite {

    @Autowired
    private ProductDbService productDbService;

    @Autowired
    private GroupDbService groupDbService;

    @Test
    public void testProductEntity() {
        //Given

        //When

        //Then
    }

    @Test
    public void testSaveProduct() {
        //Given

        //When

        //Then
    }

    @Test
    public void testUpdateProduct() {
        //Given

        //When

        //Then
    }

    @Test
    public void testDeleteProduct() {
        //Given
        Product product = new Product(1L, "product 1", "content 1", 13.00);

        try {
            productDbService.saveProduct(product);
        } catch (ProductConflictException e) {
            e.printStackTrace();
        }

        Long productId = product.getId();

        //When
        productDbService.deleteProduct(productId);
        Optional<Product> productOptional = productDbService.getProductById(productId);

        //Then
        assertFalse(productOptional.isPresent());
    }
}