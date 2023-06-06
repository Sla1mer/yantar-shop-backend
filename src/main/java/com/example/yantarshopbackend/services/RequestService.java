package com.example.yantarshopbackend.services;

import com.example.yantarshopbackend.dto.ResponseMessage;
import com.example.yantarshopbackend.dto.entities.OrderDto;
import com.example.yantarshopbackend.dto.entities.RequestDto;
import com.example.yantarshopbackend.repo.RequestDtoRepo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class RequestService {

    private final RequestDtoRepo requestDtoRepo;

    public RequestService(RequestDtoRepo requestDtoRepo) {
        this.requestDtoRepo = requestDtoRepo;
    }

    @Async
    public CompletableFuture<ResponseMessage<RequestDto>> insertRequest(RequestDto requestDto)
            throws NoSuchAlgorithmException {

        requestDto.setCreationDate(LocalDateTime.now(ZoneId.of("GMT+2")));

        return CompletableFuture.completedFuture(new
                ResponseMessage<>(200,
                "Заявка успешно отправлена.", requestDtoRepo.save(requestDto)));
    }

    @Async
    public CompletableFuture<ResponseMessage<ArrayList<RequestDto>>> getAllRequest()
            throws NoSuchAlgorithmException {

        return CompletableFuture.completedFuture(new
                ResponseMessage<>(200,
                "Заказы успешно получены.", requestDtoRepo.findAllOrderByDate()));
    }


}
