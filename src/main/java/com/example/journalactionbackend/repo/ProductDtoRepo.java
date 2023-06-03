package com.example.journalactionbackend.repo;

import com.example.journalactionbackend.dto.entities.CallQuestionDto;
import com.example.journalactionbackend.dto.entities.ProductDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProductDtoRepo extends CrudRepository<ProductDto, Long> {

    @Query(value = "SELECT * FROM products ORDER BY creation_date DESC", nativeQuery = true)
    ArrayList<ProductDto> findAllOrderByDate();
}
