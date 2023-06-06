package com.example.yantarshopbackend.repo;

import com.example.yantarshopbackend.dto.entities.OrderDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface OrderDtoRepo extends CrudRepository<OrderDto, Long> {

    @Query(value = "SELECT * FROM orders ORDER BY creation_date DESC", nativeQuery = true)
    ArrayList<OrderDto> findAllOrderByDate();
}
