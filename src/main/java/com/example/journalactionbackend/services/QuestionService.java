package com.example.journalactionbackend.services;

import com.example.journalactionbackend.dto.ResponseMessage;
import com.example.journalactionbackend.dto.auth.CredentialsDto;
import com.example.journalactionbackend.dto.entities.CallQuestionDto;
import com.example.journalactionbackend.dto.entities.TextQuestionDto;
import com.example.journalactionbackend.dto.entities.UserDto;
import com.example.journalactionbackend.repo.CallQuestionDtoRepo;
import com.example.journalactionbackend.repo.TextQuestionDtoRepo;
import com.example.journalactionbackend.utils.PasswordUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class QuestionService {

    private final TextQuestionDtoRepo textQuestionDtoRepo;
    private final CallQuestionDtoRepo callQuestionDtoRepo;

    public QuestionService(TextQuestionDtoRepo textQuestionDtoRepo, CallQuestionDtoRepo callQuestionDtoRepo) {
        this.textQuestionDtoRepo = textQuestionDtoRepo;
        this.callQuestionDtoRepo = callQuestionDtoRepo;
    }

    @Async
    public CompletableFuture<ResponseMessage<TextQuestionDto>> insertTextQuestion(TextQuestionDto textQuestionDto)
            throws NoSuchAlgorithmException {
        textQuestionDto.setCreationDate(LocalDateTime.now(ZoneId.of("GMT+2")));
        return CompletableFuture.completedFuture(new
                ResponseMessage<TextQuestionDto>(200,
                "Заявкая успешно сохранена.", textQuestionDtoRepo.save(textQuestionDto)));
    }

    @Async
    public CompletableFuture<ResponseMessage<ArrayList<TextQuestionDto>>> getAllTextQuestion()
            throws NoSuchAlgorithmException {
        return CompletableFuture.completedFuture(new
                ResponseMessage<ArrayList<TextQuestionDto>>(200,
                "Заявки успешно получены.", textQuestionDtoRepo.findAllOrderByDate()));
    }

    @Async
    public CompletableFuture<ResponseMessage<CallQuestionDto>> insertCallQuestion(CallQuestionDto callQuestionDto)
            throws NoSuchAlgorithmException {
        callQuestionDto.setCreationDate(LocalDateTime.now(ZoneId.of("GMT+2")));
        return CompletableFuture.completedFuture(new
                ResponseMessage<CallQuestionDto>(200,
                "Заявки успешно получены.", callQuestionDtoRepo.save(callQuestionDto)));
    }

    @Async
    public CompletableFuture<ResponseMessage<ArrayList<CallQuestionDto>>> getAllCallQuestion()
            throws NoSuchAlgorithmException {
        return CompletableFuture.completedFuture(new
                ResponseMessage<ArrayList<CallQuestionDto>>(200,
                "Заявкая успешно сохранена.", callQuestionDtoRepo.findAllOrderByDate()));
    }
}
