package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.controller.exceptions.ProductConflictException;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartDbService;
import com.kodilla.ecommercee.service.ProductDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {
    @Autowired
    CartMapper cartMapper;
    @Autowired
    CartDbService cartDbService;
    @Autowired
    ProductDbService productDbService;
    @Autowired
    ProductMapper productMapper;

    @PostMapping(value = "createNewCart")
    public void createNewCart() {
        cartDbService.saveCart(new Cart());
    }

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts(@RequestParam Long cartId)  {
        return productMapper.productDtoList(cartDbService.getCart(cartId).get().getProducts());
    }

    @PutMapping(value = "addToCart")
    public List<Product>addProductToCart(@RequestParam Long cartId, @RequestParam Long productId) {
       return cartDbService.getCart(cartId).get().getProducts();
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody OrderDto orderDto,@RequestParam Long cartId) {

    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long cartId, @RequestParam Long productId) {
        cartDbService.deleteCart(cartId);
    }

}