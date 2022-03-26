package com.codegym.tiktok.userPackage.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User follower;
    @ManyToOne
    private User user;
}
