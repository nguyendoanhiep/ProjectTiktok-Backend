package com.codegym.tiktok.userPackage.service.imp;

import com.codegym.tiktok.userPackage.model.Comment;
import com.codegym.tiktok.userPackage.repository.CommentRepo;
import com.codegym.tiktok.userPackage.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    CommentRepo commentRepo;


    @Override
    public List<Comment> findAllByPostId(long id) {
        return commentRepo.findAllByPostsId(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepo.deleteById(id);

    }


}
