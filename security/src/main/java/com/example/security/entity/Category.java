package com.example.security.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
