package com.example.yantarshopbackend.controllers;


import com.example.yantarshopbackend.dto.ResponseMessage;
import com.example.yantarshopbackend.dto.entities.CommentDto;
import com.example.yantarshopbackend.dto.entities.OrderDto;
import com.example.yantarshopbackend.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/insertComment")
    public ResponseEntity<ResponseMessage<CommentDto>> insertComment(@RequestBody CommentDto commentDto)
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(commentService.insertComment(commentDto).get());
    }

    @GetMapping("/getLastComments")
    public ResponseEntity<ResponseMessage<ArrayList<CommentDto>>> getLastComment()
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(commentService.getLastComments().get());
    }

    @GetMapping("/getAllComments")
    public ResponseEntity<ResponseMessage<ArrayList<CommentDto>>> getAllComments()
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(commentService.getAllComments().get());
    }
}
