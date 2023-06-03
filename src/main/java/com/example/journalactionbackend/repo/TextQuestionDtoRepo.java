package com.example.journalactionbackend.repo;

import com.example.journalactionbackend.dto.entities.CallQuestionDto;
import com.example.journalactionbackend.dto.entities.TextQuestionDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TextQuestionDtoRepo extends CrudRepository<TextQuestionDto, Long> {
    @Query(value = "SELECT * FROM text_questions ORDER BY creation_date DESC", nativeQuery = true)
    ArrayList<TextQuestionDto> findAllOrderByDate();
}
