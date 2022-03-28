package com.codegym.tiktok.userPackage.service.imp;

import com.codegym.tiktok.userPackage.model.Follow;
import com.codegym.tiktok.userPackage.repository.FollowRepo;
import com.codegym.tiktok.userPackage.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FollowServiceImp implements FollowService {
    @Autowired
    FollowRepo followRepo;
    @Override
    public List<Follow> findAllFollowerByUserId(Long id) {
        return followRepo.findAllFollowerByFollowerId(id);
    }

    @Override
    public void save(Follow follow) {
        followRepo.save(follow);
    }

    @Override
    public void unFollow(Long userId , Long followerId) {
        Follow follow = followRepo.findFollowByUserIdAndFollowerId(userId,followerId);
        followRepo.delete(follow);
    }

    @Override
    public List<Follow> findAllUserByFollowerId(long id) {
        return followRepo.findAllFollowerByUserId(id);
    }
}
