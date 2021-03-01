package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @PostMapping(value = "createNewCart")
    public void createNewCart() {

    }

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @PutMapping(value = "addToCart")
    public void addProductsToCart(@RequestParam List<ProductDto> productsDto) {

    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {

    }

    @PostMapping(value = "createOrder")
    public OrderDto createOrder(@RequestBody CartDto cartDto) {
        return new OrderDto(cartDto.getId(), cartDto.getUserId(), cartDto.getProducts());
    }
}