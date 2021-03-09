package com.kodilla.ecommercee;


import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/order")
public class OrderController {

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return new LinkedList<>();
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) {
        return new OrderDto(1L, new User(), true, true, true);
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, new User(), true, true, true);
    }

    @PostMapping(value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {

    }
}
