package com.codegym.tiktok.userPackage.service;

import com.codegym.tiktok.userPackage.model.Follow;
import com.codegym.tiktok.userPackage.model.Liked;

import java.util.List;

public interface LikedService {
    List<Liked> findAllUserByPost_id(Long id);
    void save ( Liked liked);
    void unlike( Long userI , Long postsId);
}
