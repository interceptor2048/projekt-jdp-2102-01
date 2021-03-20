package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderDbService;
import com.kodilla.ecommercee.service.information.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    OrderMapper mapper;
    @Autowired
    OrderDbService service;
    @Autowired
    EmailSender emailSender;

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return mapper.mapToOrderDtoList(service.getAllOrders());
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        return mapper.mapToOrderDto(service.getOrder(orderId).orElseThrow(OrderNotFoundException::new));
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        service.deleteOrder(orderId);
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        Order savedOrder = service.saveOrder(mapper.mapToOrder(orderDto));
        return mapper.mapToOrderDto(savedOrder);
    }

    @PostMapping(value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {
        service.saveOrder(mapper.mapToOrder(orderDto));
        //emailSender.notifyOrderCreated(mapper.mapToOrder(orderDto));
    }
}
