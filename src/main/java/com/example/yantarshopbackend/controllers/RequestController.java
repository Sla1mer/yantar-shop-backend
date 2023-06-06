package com.example.yantarshopbackend.controllers;

import com.example.yantarshopbackend.dto.ResponseMessage;
import com.example.yantarshopbackend.dto.entities.OrderDto;
import com.example.yantarshopbackend.dto.entities.RequestDto;
import com.example.yantarshopbackend.services.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/request")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/insertRequest")
    public ResponseEntity<ResponseMessage<RequestDto>> insertRequest(@RequestBody RequestDto requestDto)
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(requestService.insertRequest(requestDto).get());
    }

    @GetMapping("/getAllRequest")
    public ResponseEntity<ResponseMessage<ArrayList<RequestDto>>> getAllRequest()
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(requestService.getAllRequest().get());
    }
}
