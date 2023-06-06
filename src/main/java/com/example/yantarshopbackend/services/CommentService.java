package com.example.yantarshopbackend.services;

import com.example.yantarshopbackend.dto.ResponseMessage;
import com.example.yantarshopbackend.dto.entities.CommentDto;
import com.example.yantarshopbackend.repo.CommentDtoRepo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class CommentService {

    private final CommentDtoRepo commentDtoRepo;

    public CommentService(CommentDtoRepo commentDtoRepo) {
        this.commentDtoRepo = commentDtoRepo;
    }

    @Async
    public CompletableFuture<ResponseMessage<CommentDto>> insertComment(CommentDto commentDto) {
        return CompletableFuture.completedFuture
                (new ResponseMessage<>(200,
                "Комментарий отправлен",
                commentDtoRepo.save(commentDto)));
    }

    @Async
    public CompletableFuture<ResponseMessage<ArrayList<CommentDto>>> getLastComments() {
        return CompletableFuture.completedFuture
                (new ResponseMessage<>(200,
                        "Комментарий получены",
                        commentDtoRepo.findLast5OrderById()));
    }

    @Async
    public CompletableFuture<ResponseMessage<ArrayList<CommentDto>>> getAllComments() {
        return CompletableFuture.completedFuture
                (new ResponseMessage<>(200,
                        "Комментарий получены",
                        commentDtoRepo.findAllOrderById()));
    }
}
