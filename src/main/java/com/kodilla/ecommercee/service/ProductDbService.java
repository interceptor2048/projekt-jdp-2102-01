package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.controller.exceptions.ProductConflictException;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDbService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(final Long productId) {
        return productRepository.findById(productId);
    }

    public Product saveProduct(final Product product) throws ProductConflictException {
        if (!productRepository.existsByProductName(product.getProductName())) {
            return productRepository.save(product);
        } else {
            throw new ProductConflictException();
        }
    }

    public void deleteProduct(final Long productId) {
        productRepository.deleteById(productId);
    }
}

