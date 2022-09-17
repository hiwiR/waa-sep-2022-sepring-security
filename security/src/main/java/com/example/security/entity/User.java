package com.example.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;


    public User(String password, String username) {
        this.email=username;
        this.password=password;
    }

    public User() {

    }

    public User(int id, String password, String username) {
        this.id=id;
        this.email=username;
        this.password=password;
    }
}
