package com.example.journalactionbackend.services;


import com.example.journalactionbackend.dto.ResponseMessage;
import com.example.journalactionbackend.dto.entities.ProductDto;
import com.example.journalactionbackend.dto.entities.TextQuestionDto;
import com.example.journalactionbackend.repo.ProductDtoRepo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    private final ProductDtoRepo productDtoRepo;

    public ProductService(ProductDtoRepo productDtoRepo) {
        this.productDtoRepo = productDtoRepo;
    }

    @Async
    public CompletableFuture<ResponseMessage<ProductDto>> insertProduct(ProductDto productDto)
            throws NoSuchAlgorithmException {
        productDto.setCreationDate(LocalDateTime.now(ZoneId.of("GMT+2")));
        return CompletableFuture.completedFuture(new
                ResponseMessage<ProductDto>(200,
                "Заказ успешно сохранен.", productDtoRepo.save(productDto)));
    }

    @Async
    public CompletableFuture<ResponseMessage<ArrayList<ProductDto>>> getAllProduct()
            throws NoSuchAlgorithmException {
        return CompletableFuture.completedFuture(new
                ResponseMessage<ArrayList<ProductDto>>(200,
                "Заказы успешно получены.", productDtoRepo.findAllOrderByDate()));
    }
}
