package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {
    private final CartMapper cartMapper;
   private final CartDbService cartDbService;

   @Autowired
    public CartController(CartMapper cartMapper, CartDbService cartDbService) {
        this.cartMapper = cartMapper;
        this.cartDbService = cartDbService;
    }

    @PostMapping(value = "createNewCart")
    public void createNewCart() {
    }

    @GetMapping(value = "getProducts")
    public List<CartDto> getProducts() {
        return new ArrayList<>();
    }

    @PutMapping(value = "addToCart")
    public void addProductToCart(@RequestParam Long cartId, @RequestParam Long productId) {

    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long cartId, @RequestParam Long productId) {

    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody CartDto cartDto) {

    }
}