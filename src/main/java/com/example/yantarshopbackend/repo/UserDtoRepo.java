package com.example.yantarshopbackend.repo;

import com.example.yantarshopbackend.dto.entities.UserDto;
import org.springframework.data.repository.CrudRepository;

public interface UserDtoRepo extends CrudRepository<UserDto, Long> {

    UserDto findByLoginAndPassword(String login, String password);
    UserDto findByLogin(String login);

}
