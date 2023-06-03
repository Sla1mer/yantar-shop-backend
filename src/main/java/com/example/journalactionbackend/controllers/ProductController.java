package com.example.journalactionbackend.controllers;

import com.example.journalactionbackend.dto.ResponseMessage;
import com.example.journalactionbackend.dto.entities.ProductDto;
import com.example.journalactionbackend.dto.entities.TextQuestionDto;
import com.example.journalactionbackend.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ResponseMessage<ProductDto>> insertTextQuestion(@RequestBody ProductDto productDto)
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(productService.insertProduct(productDto).get());
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<ResponseMessage<ArrayList<ProductDto>>> getAllProduct()
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(productService.getAllProduct().get());
    }
}
