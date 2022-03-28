package com.codegym.tiktok.userPackage.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Liked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Posts posts;
}
