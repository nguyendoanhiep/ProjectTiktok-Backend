package com.codegym.tiktok.userPackage.repository;

import com.codegym.tiktok.userPackage.model.Comment;
import com.codegym.tiktok.userPackage.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepo extends JpaRepository<Posts, Long> {
    List<Posts> findAllByUserId(long id);

}
