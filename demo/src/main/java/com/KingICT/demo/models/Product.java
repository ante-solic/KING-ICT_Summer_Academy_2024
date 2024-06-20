package com.KingICT.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    private long id;

    public String title;

    public String description;

    private String category;

    private double price;
}
