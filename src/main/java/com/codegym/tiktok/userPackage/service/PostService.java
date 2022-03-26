package com.codegym.tiktok.userPackage.service;

import com.codegym.tiktok.userPackage.model.Posts;

import java.util.List;

public interface PostService {
    List<Posts> findAll();
    Posts save(Posts posts);
    void delete(Long id);
    Posts findById(Long id );
    List<Posts> findAllByUserId(long id);


}
