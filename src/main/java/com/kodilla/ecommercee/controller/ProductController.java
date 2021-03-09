package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.controller.exceptions.ProductConflictException;
import com.kodilla.ecommercee.controller.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductDbService;
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
    public ProductDto updateProduct(@RequestBody ProductDto productDto) throws ProductConflictException {
        return productMapper.mapProductDto(productDbService.saveProduct(productMapper.mapToProduct(productDto)));
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        productDbService.deleteProduct(productId);

    }
}
