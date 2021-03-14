
package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.controller.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.controller.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartDbService;
import com.kodilla.ecommercee.service.OrderItemsDbService;
import com.kodilla.ecommercee.service.ProductDbService;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserDbService userDbService;

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
    public void createOrder(@RequestParam Long userId, @RequestParam Long cartId) throws Exception {
        Order theOrder = new Order();
        Cart cart = cartDbService.getCart(cartId).orElseThrow(CartNotFoundException::new);
        User user = userDbService.getUser(userId).orElseThrow(UserNotFoundException::new);

        List<OrderItem> orderItemList = cart.getProducts().stream()
                .map(product -> new OrderItem(product,theOrder)).collect(toList());
        theOrder.setOrderItems(orderItemList);
        theOrder.setUser(user);
        orderController.createOrder(orderMapper.mapToOrderDto(theOrder));
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long cartId, @RequestParam Long productId) throws Exception{
        Product product = productDbService.getProductById(productId).orElseThrow(ProductNotFoundException::new);
        cartDbService.getCart(cartId).orElseThrow(CartNotFoundException::new).getProducts().remove(product);
    }
}