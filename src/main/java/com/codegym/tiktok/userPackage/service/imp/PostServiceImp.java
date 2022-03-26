package com.codegym.tiktok.userPackage.service.imp;

import com.codegym.tiktok.userPackage.model.Posts;
import com.codegym.tiktok.userPackage.repository.PostRepo;
import com.codegym.tiktok.userPackage.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImp implements PostService {
    @Autowired
    PostRepo postRepo;
    @Override
    public List<Posts> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Posts save(Posts posts) {
        return postRepo.save(posts);
    }

    @Override
    public void delete(Long id) {
            postRepo.deleteById(id);
    }

    @Override
    public Posts findById(Long id) {
        return postRepo.findById(id).get();
    }

    @Override
    public List<Posts> findAllByUserId(long id) {
        return postRepo.findAllByUserId(id);
    }
}
