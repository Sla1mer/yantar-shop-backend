package com.example.yantarshopbackend.repo;

import com.example.yantarshopbackend.dto.entities.OrderDto;
import com.example.yantarshopbackend.dto.entities.ProductDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProductDtoRepo extends CrudRepository<ProductDto, Long> {
    @Query(value = "SELECT * FROM products ORDER BY id DESC", nativeQuery = true)
    ArrayList<ProductDto> findAllOrderById();
}
