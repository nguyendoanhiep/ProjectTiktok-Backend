package com.codegym.tiktok.userPackage.repository;

import com.codegym.tiktok.userPackage.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    List<Comment> findAllByPostsId(long id);

}
