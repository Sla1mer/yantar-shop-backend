package com.example.journalactionbackend.repo;

import com.example.journalactionbackend.dto.entities.CallQuestionDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CallQuestionDtoRepo extends CrudRepository<CallQuestionDto, Long> {

    @Query(value = "SELECT * FROM call_question ORDER BY creation_date DESC", nativeQuery = true)
    ArrayList<CallQuestionDto> findAllOrderByDate();
}
