package com.example.yantarshopbackend.controllers;

import com.example.yantarshopbackend.dto.ResponseMessage;
import com.example.yantarshopbackend.dto.entities.OrderDto;
import com.example.yantarshopbackend.dto.entities.ProductDto;
import com.example.yantarshopbackend.dto.product.InsertProductDto;
import com.example.yantarshopbackend.services.OrderService;
import com.example.yantarshopbackend.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/insertProduct")
    public ResponseEntity<ResponseMessage<ProductDto>> insertProduct(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "desc", required = false) String desc,
            @RequestParam(value = "price", required = false) int price
    ) throws ExecutionException, InterruptedException, NoSuchAlgorithmException, IOException {
        InsertProductDto insertProductDto = new InsertProductDto(title, desc,
                price, null, file);

        return ResponseEntity.ok(productService.insertProduct(insertProductDto).get());
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<ResponseMessage<ArrayList<ProductDto>>> getAllProduct()
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(productService.getAllProduct().get());
    }
}
