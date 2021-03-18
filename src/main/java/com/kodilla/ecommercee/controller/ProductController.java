package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.ProductConflictException;
import com.kodilla.ecommercee.controller.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductDbService;
import com.kodilla.ecommercee.service.UserDbService;
import com.kodilla.ecommercee.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    @Autowired
    ProductDbService productDbService;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    UserDbService userDbService;

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.productDtoList(productDbService.getAllProducts());
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws ProductNotFoundException {
        return productMapper.mapProductDto(productDbService.getProductById(productId).orElseThrow(ProductNotFoundException::new));
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) throws ProductConflictException {
        productDbService.saveProduct(productMapper.mapToProduct(productDto));

    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto,@RequestParam Long userId, @RequestParam Long key) throws ProductConflictException, NotFoundException {
        userDbService.validateGeneratedKey(userId,key);
        return productMapper.mapProductDto(productDbService.saveProduct(productMapper.mapToProduct(productDto)));
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId, @RequestParam Long userId, @RequestParam Long key ) throws NotFoundException {
        userDbService.validateGeneratedKey(userId,key);
        productDbService.deleteProduct(productId);

    }
}
