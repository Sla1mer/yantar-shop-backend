package com.example.yantarshopbackend.controllers;

import com.example.yantarshopbackend.config.UserAuthenticationProvider;
import com.example.yantarshopbackend.dto.ResponseMessage;
import com.example.yantarshopbackend.dto.auth.AfterSignInInfoDto;
import com.example.yantarshopbackend.dto.auth.TokensDto;
import com.example.yantarshopbackend.dto.entities.UserDto;
import com.example.yantarshopbackend.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private final UserAuthenticationProvider userAuthenticationProvider;

    public AuthenticationController(AuthenticationService authenticationService, UserAuthenticationProvider userAuthenticationProvider) {
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @PostMapping("/signIn")
    public ResponseEntity<ResponseMessage<AfterSignInInfoDto>> signIn(@AuthenticationPrincipal UserDto user) throws ExecutionException, InterruptedException {
        AfterSignInInfoDto afterSignInInfoDto =
                new AfterSignInInfoDto(
                        userAuthenticationProvider.createToken(user.getLogin()), user);

        return ResponseEntity.ok(new ResponseMessage<>(200, "Вы успешно вошли", afterSignInInfoDto));
    }

    @PostMapping("/refreshTokens")
    public ResponseEntity<ResponseMessage<TokensDto>> refreshTokens(@AuthenticationPrincipal UserDto user) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(new ResponseMessage<>(200,
                "Вы успешно обновили токены",
                userAuthenticationProvider.createToken(user.getLogin())));
    }

}
