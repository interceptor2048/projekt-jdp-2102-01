package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class ProductEntityTestSuite {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void testSaveProduct() {
        //Given
        Product asus = new Product(1L, "asus", "asus rog", 2313.00);
        Product lenovo = new Product(2L, "lenovo", "lenovo legion y720", 3234.00);
        Group group = new Group();

        group.getProductList().add(asus);
        group.getProductList().add(lenovo);
        asus.setGroup(group);
        lenovo.setGroup(group);

        groupRepository.save(group);
        productRepository.save(asus);
        productRepository.save(lenovo);

        long groupId = group.getId();
        long getProduct1Id = asus.getGroup().getId();
        long getProduct2Id = lenovo.getGroup().getId();

        //When
        List<Product> resultProductsList = productRepository.findAll();

        //Then
        assertNotEquals(0, groupId);
        assertEquals(groupId, getProduct1Id);
        assertEquals(groupId, getProduct2Id);
        assertEquals(2, resultProductsList.size());

        //CleanUp
        productRepository.deleteAll();
    }

    @Test
    public void testUpdateProduct() {
        //Given
        Product tv = new Product(3L, "tv", "tv led", 623.00);
        productRepository.save(tv);

        Product productInDb = productRepository.findAll().get(0);
        productInDb.setProductName("product update");
        productInDb.setProductDescription("content update");
        productInDb.setPrice(13.00);
        productRepository.save(productInDb);

        //When
        long id = productInDb.getId();
        Optional<Product> updateProduct = productRepository.findById(id);

        //Then
        assertTrue(updateProduct.isPresent());
        assertEquals("product update", updateProduct.get().getProductName());

        //CleanUp
        productRepository.deleteAll();
    }

    @Test
    public void testDeleteProductById() {
        //Given
        Product ssdDrive = new Product(4L, "Crucial", "Crucial bx500", 13.00);
        productRepository.save(ssdDrive);

        //When
        Long id = productRepository.findAll().get(0).getId();
        productRepository.deleteById(id);

        //Then
        assertFalse(productRepository.findById(id).isPresent());
    }

    @Test
    public void testFindAllProducts() {
        //Given
        Product pendrive = new Product(1L, "pendrive", "pendrive 32GB", 42.00);
        Product ssd = new Product(2L, "ssd", "ssd 512GB", 452.00);

        productRepository.save(pendrive);
        productRepository.save(ssd);

        //When
        List<Product> resultProducts = productRepository.findAll();

        //Then
        assertEquals(2, resultProducts.size());
    }
}