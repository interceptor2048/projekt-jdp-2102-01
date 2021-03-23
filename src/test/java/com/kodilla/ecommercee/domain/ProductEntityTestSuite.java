package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.*;

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
public class ProductEntityTestSuite {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CartRepository cartRepository;


    @Test
    public void testProductInGroup() {
        //Given
        Group group = new Group();
        group.setGroupName("Group 1");
        groupRepository.save(group);

        Product asus = new Product();
        group.getProductList().add(asus);
        asus.setProductName("asus");
        asus.setProductDescription("asus rog");
        asus.setPrice(4500.00);
        asus.setGroup(group);
        productRepository.save(asus);

        //When
        long productId = asus.getId();
        long groupId = group.getId();
        List<Product> productList = productRepository.findAll();

        //Then
        assertTrue(productRepository.findById(productId).isPresent());
        assertTrue(groupRepository.findById(groupId).isPresent());
        assertEquals("Group 1", productList.get(0).getGroup().getGroupName());
    }


    @Test
    public void testProductsInOrderItem() {
        //Given
        Product asus = new Product();
        asus.setProductName("asus");
        asus.setProductDescription("asus rog");
        asus.setPrice(4500.00);
        productRepository.save(asus);

        OrderItem orderItems1 = new OrderItem();
        orderItems1.setProduct(asus);
        orderItemRepository.save(orderItems1);

        //When
        List<OrderItem> orderItemList = orderItemRepository.findAll();

        //Then
        assertEquals(1, orderItemList.size());
        assertEquals("asus", orderItemList.get(0).getProduct().getProductName());
    }

    @Test
    public void testProductInCart() {
        //Given
        Product asus = new Product();
        asus.setProductName("asus");
        asus.setProductDescription("asus rog 7");
        asus.setPrice(3700.00);
        Product lenovo = new Product();
        lenovo.setProductName("lenovo");
        lenovo.setProductDescription("lenovo y520");
        lenovo.setPrice(4500.00);
        productRepository.save(asus);
        productRepository.save(lenovo);

        List<Product> productList = new ArrayList<>();
        productList.add(asus);
        productList.add(lenovo);

        User user = new User("Pablo");
        user.setUserKey(12345L);
        user.setAddress("Poland");
        user.setEmail("pablo@mail");
        user.setPhoneNumber("522112344");
        userRepository.save(user);

        Cart cart = new Cart(1L, user, productList);
        cartRepository.save(cart);

        //When
        Cart resultCartFromDb = cartRepository.findAll().get(0);
        Product resultProduct1 = resultCartFromDb.getProducts().get(0);
        Product resultProduct2 = resultCartFromDb.getProducts().get(1);

        //Then
        assertEquals("Pablo", resultCartFromDb.getUser().getUserName());
        assertEquals(2, resultCartFromDb.getProducts().size());
        assertEquals("asus", resultProduct1.getProductName());
        assertEquals("lenovo", resultProduct2.getProductName());
    }

    @Test
    public void testDeleteProductById() {
        //Given
        Product ssdDrive = new Product(7L, "Crucial", "Crucial bx500", 13.00);
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
        Product pendrive = new Product(19L, "pendrive", "pendrive 32GB", 42.00);
        Product ssd = new Product(31L, "ssd", "ssd 512GB", 452.00);

        productRepository.save(pendrive);
        productRepository.save(ssd);

        //When
        List<Product> resultProducts = productRepository.findAll();

        //Then
        assertEquals(2, resultProducts.size());
    }
}