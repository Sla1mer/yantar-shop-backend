package com.example.yantarshopbackend.controllers;

import com.example.yantarshopbackend.dto.ResponseMessage;
import com.example.yantarshopbackend.dto.entities.OrderDto;
import com.example.yantarshopbackend.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/insertOrder")
    public ResponseEntity<ResponseMessage<OrderDto>> insertOrder(@RequestBody OrderDto productDto)
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(orderService.insertProduct(productDto).get());
    }

    @GetMapping("/getAllOrder")
    public ResponseEntity<ResponseMessage<ArrayList<OrderDto>>> getAllOrder()
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(orderService.getAllProduct().get());
    }
}
