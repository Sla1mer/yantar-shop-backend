package com.example.yantarshopbackend.services;

import com.example.yantarshopbackend.dto.ResponseMessage;
import com.example.yantarshopbackend.dto.entities.OrderDto;
import com.example.yantarshopbackend.dto.entities.ProductDto;
import com.example.yantarshopbackend.dto.product.InsertProductDto;
import com.example.yantarshopbackend.repo.ProductDtoRepo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    private final ProductDtoRepo productDtoRepo;

    public ProductService(ProductDtoRepo productDtoRepo) {
        this.productDtoRepo = productDtoRepo;
    }


    @Async
    public CompletableFuture<ResponseMessage<ProductDto>> insertProduct(InsertProductDto insertProductDto) throws IOException {
        File uploadDir = new File("").getAbsoluteFile();

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        String[] fileNameSplit = insertProductDto.getFile().getOriginalFilename().split("\\.");

        String fileName = UUID.randomUUID() + "." + fileNameSplit[fileNameSplit.length - 1];

        String path = new File("")
                .getAbsoluteFile().toString() + "/src/main/resources/static/";

        FileOutputStream fout = new FileOutputStream(path + fileName);
        fout.write(insertProductDto.getFile().getBytes());
        fout.flush();
        fout.close();


        ProductDto productDto = new ProductDto(insertProductDto.getTitle(),
                insertProductDto.getDescription(), insertProductDto.getPrice(), fileName);

        return CompletableFuture.completedFuture(new
                ResponseMessage<ProductDto>(200,
                "Заказ успешно сохранен.", productDtoRepo.save(productDto)));
    }

    @Async
    public CompletableFuture<ResponseMessage<ArrayList<ProductDto>>> getAllProduct() {
        return CompletableFuture.completedFuture(new
                ResponseMessage<ArrayList<ProductDto>>(200,
                "Заказ успешно сохранен.", productDtoRepo.findAllOrderById()));
    }
}
