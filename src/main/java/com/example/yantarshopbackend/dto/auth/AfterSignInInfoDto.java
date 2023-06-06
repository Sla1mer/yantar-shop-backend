package com.example.yantarshopbackend.dto.auth;

import com.example.yantarshopbackend.dto.entities.UserDto;

public class AfterSignInInfoDto {
    private TokensDto tokensDto;
    private UserDto userDto;

    public AfterSignInInfoDto() {
    }

    public AfterSignInInfoDto(TokensDto tokensDto, UserDto userDto) {
        this.tokensDto = tokensDto;
        this.userDto = userDto;
    }

    public TokensDto getTokensDto() {
        return tokensDto;
    }

    public void setTokensDto(TokensDto tokensDto) {
        this.tokensDto = tokensDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
