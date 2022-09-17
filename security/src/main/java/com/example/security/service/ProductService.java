package com.example.security.service;

import com.example.security.Product;
import com.example.security.entity.User;
import com.example.security.repository.ProductRepository;
import com.example.security.security.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public void saveNewProduct(Product product){
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetail userDetail = (MyUserDetail) user.getPrincipal();
        product.setUser((new User(userDetail.getId(),userDetail.getPassword(),userDetail.getUsername())));
        //product.setUser();
       productRepository.save(product);

    }
}
