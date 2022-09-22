package com.example.security.service;

import com.example.security.entity.Product;

import java.util.List;

public interface ProductService {
     void saveNewProduct(Product product);

    List<Product> getAllProducts();
}
