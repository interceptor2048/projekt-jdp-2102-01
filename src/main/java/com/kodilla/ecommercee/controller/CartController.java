
package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.OrderController;
import com.kodilla.ecommercee.controller.exceptions.CartNotFoundException;
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
    @Autowired
    OrderController orderController;

    @PostMapping(value = "createNewCart")
    public void createNewCart() {
        cartDbService.saveCart(new Cart());
    }

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts(@RequestParam Long cartId) {
        return productMapper.productDtoList(cartDbService.getCart(cartId).get().getProducts());
    }

    @PutMapping(value = "addToCart")
    public void addProductToCart(@RequestParam Long cartId, @RequestParam Long productId) throws CartNotFoundException {
        Cart cart = cartDbService.getCart(cartId).orElseThrow(CartNotFoundException::new);
        Product product = productDbService.getProductById(productId).get();
        cart.getProducts().add(product);
        cartDbService.saveCart(cart);
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody OrderDto orderDto, @RequestParam Long cartId) throws CartNotFoundException {
        OrderDto theOrder = orderController.getOrder(orderDto.getId());
        Cart cart = cartDbService.getCart(cartId).orElseThrow(CartNotFoundException::new);
        cart.getProducts();
        orderController.createOrder(theOrder);
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long cartId, @RequestParam Long productId) {
        cartDbService.deleteCart(cartId);
    }

}