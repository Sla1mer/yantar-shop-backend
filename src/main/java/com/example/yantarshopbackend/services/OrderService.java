package com.example.yantarshopbackend.services;


import com.example.yantarshopbackend.dto.ResponseMessage;
import com.example.yantarshopbackend.dto.entities.OrderDto;
import com.example.yantarshopbackend.repo.OrderDtoRepo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderService {

    private final OrderDtoRepo orderDtoRepo;

    public OrderService(OrderDtoRepo orderDtoRepo) {
        this.orderDtoRepo = orderDtoRepo;
    }

    @Async
    public CompletableFuture<ResponseMessage<OrderDto>> insertProduct(OrderDto productDto)
            throws NoSuchAlgorithmException {
        productDto.setCreationDate(LocalDateTime.now(ZoneId.of("GMT+2")));
        return CompletableFuture.completedFuture(new
                ResponseMessage<OrderDto>(200,
                "Заказ успешно сохранен.", orderDtoRepo.save(productDto)));
    }

    @Async
    public CompletableFuture<ResponseMessage<ArrayList<OrderDto>>> getAllProduct()
            throws NoSuchAlgorithmException {
        return CompletableFuture.completedFuture(new
                ResponseMessage<ArrayList<OrderDto>>(200,
                "Заказы успешно получены.", orderDtoRepo.findAllOrderByDate()));
    }
}
