package com.codegym.tiktok.userPackage.model;

import com.codegym.tiktok.securityPackage.model.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickName;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private int age;
    private String gender;
    private String city;
    private String nationality;
    private int status;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>() ;


    public User(
                     String name,
                     String username,
                     String email,
                    String avatar,
                    String encode

    ) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.password = encode;
    }

    public User() {

    }
}
