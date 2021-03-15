package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.controller.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartDbService {
    @Autowired
    private final CartRepository repository;

    public List<Cart> getAllCarts() {
        return repository.findAll();
    }

    public Optional<Cart> getCart(final Long cartId) {
        return repository.findById(cartId);
    }

    public Cart saveCart(Cart cart) {
        return repository.save(cart);
    }

    public void deleteCart(final Long cartId) {
        repository.deleteById(cartId);
    }
<<<<<<< HEAD

    public  void deleteOrder(final Long orderId){
        //orderRepository.deleteById(orderId);
    }

=======
>>>>>>> master
}
