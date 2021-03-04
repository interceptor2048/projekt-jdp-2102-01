package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class ProductEntityTestSuite {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testProductEntity() {
        //Given

        //When

        //Then
    }

    @Test
    public void testProductSave() {
        //Given

        //When

        //Then
    }

    @Test
    public void testProductUpdate() {
        //Given

        //When

        //Then
    }

    @Test
    public void testProductDelete() {
        //Given

        //When

        //Then
    }
}
