package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {
    public Product mapToProduct(ProductDto productDto) {
        return new Product (productDto.getId(), productDto.getProductName(), productDto.getDescription(), productDto.getPrice(),productDto.getGroup());
    }

    public ProductDto mapProductDto(Product product) {
        return new ProductDto(product.getId(), product.getProductName(), product.getProductDescription(), product.getPrice(), product.getGroup());
    }

    public List<ProductDto> productDtoList(final List<Product> productList) {
        return productList.stream().map(this::mapProductDto).collect(Collectors.toList());
    }

    public List<Product> productList(final List<ProductDto> productDtoList) {
        return productDtoList.stream().map(this::mapToProduct).collect(Collectors.toList());
    }
}

