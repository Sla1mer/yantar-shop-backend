package com.example.journalactionbackend.controllers;

import com.example.journalactionbackend.dto.ResponseMessage;
import com.example.journalactionbackend.dto.auth.TokensDto;
import com.example.journalactionbackend.dto.entities.CallQuestionDto;
import com.example.journalactionbackend.dto.entities.TextQuestionDto;
import com.example.journalactionbackend.dto.entities.UserDto;
import com.example.journalactionbackend.services.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/insertTextQuestion")
    public ResponseEntity<ResponseMessage<TextQuestionDto>> insertTextQuestion(@RequestBody TextQuestionDto textQuestionDto)
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(questionService.insertTextQuestion(textQuestionDto).get());
    }

    @PostMapping("/insertCallQuestion")
    public ResponseEntity<ResponseMessage<CallQuestionDto>> insertCallQuestion(@RequestBody CallQuestionDto callQuestionDto)
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(questionService.insertCallQuestion(callQuestionDto).get());
    }

    @GetMapping("/getAllTextQuestion")
    public ResponseEntity<ResponseMessage<ArrayList<TextQuestionDto>>> getAllTextQuestion()
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(questionService.getAllTextQuestion().get());
    }

    @GetMapping("/getAllCallQuestion")
    public ResponseEntity<ResponseMessage<ArrayList<CallQuestionDto>>> getAllCallQuestion()
            throws ExecutionException, InterruptedException, NoSuchAlgorithmException {
        return ResponseEntity.ok(questionService.getAllCallQuestion().get());
    }
}
