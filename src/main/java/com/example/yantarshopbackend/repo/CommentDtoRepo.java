package com.example.yantarshopbackend.repo;

import com.example.yantarshopbackend.dto.entities.CommentDto;
import com.example.yantarshopbackend.dto.entities.ProductDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CommentDtoRepo extends CrudRepository<CommentDto, Long> {

    @Query(value = "SELECT * FROM comments ORDER BY id DESC LIMIT 5", nativeQuery = true)
    ArrayList<CommentDto> findLast5OrderById();

    @Query(value = "SELECT * FROM comments ORDER BY id DESC", nativeQuery = true)
    ArrayList<CommentDto> findAllOrderById();
}
