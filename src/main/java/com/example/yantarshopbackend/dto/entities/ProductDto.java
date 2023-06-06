package com.example.yantarshopbackend.dto.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private int price;
    private String pathImage;

    public ProductDto() {
    }

    public ProductDto(long id, String title, String description, int price, String pathImage) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.pathImage = pathImage;
    }

    public ProductDto(String title, String description, int price, String pathImage) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.pathImage = pathImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }
}
