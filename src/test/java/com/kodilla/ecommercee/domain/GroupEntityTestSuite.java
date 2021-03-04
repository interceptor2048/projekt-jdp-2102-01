package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class GroupEntityTestSuite {
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testGroupDaoCreateReadSave() {
        //Given
        Group group = new Group();
        //When
        groupRepository.save(group);
        long id = group.getId();
        Optional<Group> readGroup = groupRepository.findById(id);
        //Then
        Assert.assertTrue(readGroup.isPresent());

        groupRepository.deleteById(id);
    }

    @Test
    public void testGroupDaoCreateReadDelete() {
        //Given
        Group group = new Group();
        //When
        groupRepository.save(group);
        long id = group.getId();
        groupRepository.deleteById(id);
        Optional<Group> readGroup = groupRepository.findById(id);
        //Then
        Assert.assertFalse(readGroup.isPresent());
    }

    @Test
    public void testGroupUpdate() {
        //Given
        Group group = new Group();
        //When
        groupRepository.save(group);
        long id = group.getId();
        group.setGroupName("productsName");
        //Then
        assertEquals("productsName", group.getGroupName());

        groupRepository.deleteById(id);
    }

    @Test
    public void testRelationsBetweenProductGroupSave() {
        //Given
        Group group = new Group();
        Product computer = new Product(1L,
                "name of first product",
                "description of first product",
                100.0);
        Product printer = new Product(2L,
                "name of second product",
                "description of second product",
                200.0);

        //When
        group.getProductList().add(computer);
        group.getProductList().add(printer);
        computer.setGroup(group);
        printer.setGroup(group);
        groupRepository.save(group);
        long groupId = group.getId();
        long getIdFromComputer = computer.getGroup().getId();
        long getIdFromPrinter = computer.getGroup().getId();
        //Then
        Assert.assertNotEquals(0, groupId);
        Assert.assertEquals(groupId, getIdFromComputer);
        Assert.assertEquals(groupId, getIdFromPrinter);

        groupRepository.deleteById(groupId);

    }

    @Test
    public void testRelationsBetweenProductGroupDelete() {
        //Given
        Group group = new Group();
        Product computer = new Product(1L,
                "name of first product",
                "description of first product",
                90.0);
        Product printer = new Product(2L,
                "name of second product",
                "description of second product",
                290.0);
        //When
        group.getProductList().add(computer);
        group.getProductList().add(printer);
        computer.setGroup(group);
        printer.setGroup(group);
        groupRepository.save(group);
        productRepository.save(computer);
        productRepository.save(printer);
        long groupId = group.getId();
        long getIdComputer = computer.getId();
        long getIdPrinter = printer.getId();
        productRepository.deleteById(getIdComputer);
        productRepository.deleteById(getIdPrinter);
        groupRepository.deleteById(groupId);
        Optional<Product> readComputer = productRepository.findById(getIdComputer);
        Optional<Product> readPrinter = productRepository.findById(getIdPrinter);
        Optional<Group> redGroup = groupRepository.findById(groupId);
        //Then
        Assert.assertFalse(readComputer.isPresent());
        Assert.assertFalse(readPrinter.isPresent());
        Assert.assertFalse(redGroup.isPresent());

    }
}
