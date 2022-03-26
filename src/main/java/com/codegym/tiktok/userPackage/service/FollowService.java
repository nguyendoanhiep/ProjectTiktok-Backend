package com.codegym.tiktok.userPackage.service;

import com.codegym.tiktok.userPackage.model.Follow;

import java.util.List;

public interface FollowService {
    List<Follow> findAllFollowerByUserId(Long id);
    void save ( Follow follow);
    void unFollow( Long userI , Long followerId);

}
