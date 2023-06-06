package com.example.yantarshopbackend.dto.product;

import com.example.yantarshopbackend.dto.entities.ProductDto;
import org.springframework.web.multipart.MultipartFile;

public class InsertProductDto extends ProductDto {
    private MultipartFile file;

    public InsertProductDto() {
    }

    public InsertProductDto(MultipartFile file) {
        this.file = file;
    }

    public InsertProductDto(String title, String description, int price, String pathImage, MultipartFile file) {
        super(title, description, price, pathImage);
        this.file = file;
    }

    public InsertProductDto(long id, String title, String description, int price, String pathImage, MultipartFile file) {
        super(id, title, description, price, pathImage);
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
