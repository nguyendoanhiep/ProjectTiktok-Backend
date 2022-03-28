package com.codegym.tiktok.userPackage.service.imp;

import com.codegym.tiktok.userPackage.model.Liked;
import com.codegym.tiktok.userPackage.repository.LikeRepo;
import com.codegym.tiktok.userPackage.service.LikedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LikedServiceImp implements LikedService {
    @Autowired
    LikeRepo likeRepo;
    @Override
    public List<Liked> findAllUserByPost_id(Long id) {
        return likeRepo.findAllUserByPosts_Id(id);
    }

    @Override
    public void save(Liked liked) {
            likeRepo.save(liked);
    }

    @Override
    public void unlike(Long postsId , Long userId) {
        Liked liked = likeRepo.unlike(postsId , userId);
        likeRepo.delete(liked);
    }
}
