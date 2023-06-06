package com.example.yantarshopbackend.repo;

import com.example.yantarshopbackend.dto.entities.ProductDto;
import com.example.yantarshopbackend.dto.entities.RequestDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RequestDtoRepo extends CrudRepository<RequestDto, Long> {

    @Query(value = "SELECT * FROM requests ORDER BY creation_date DESC", nativeQuery = true)
    ArrayList<RequestDto> findAllOrderByDate();
}
