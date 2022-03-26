package com.codegym.tiktok.userPackage.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Posts {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String link;
        private String content;

        @ManyToOne
        private User user;

}
