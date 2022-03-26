package com.codegym.tiktok.userPackage.service;

import com.codegym.tiktok.userPackage.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAllByPostId(long id);
    Comment save(Comment comment);
    void delete(Long id);
}
