package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private Long userId;
    private List<ProductDto> products = new ArrayList<>();
}
