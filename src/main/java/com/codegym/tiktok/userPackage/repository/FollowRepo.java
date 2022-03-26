package com.codegym.tiktok.userPackage.repository;

import com.codegym.tiktok.userPackage.model.Comment;
import com.codegym.tiktok.userPackage.model.Follow;
import com.codegym.tiktok.userPackage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepo extends JpaRepository<Follow,Long> {
    
//    @Query(nativeQuery = true,value = "select * from follow f where f.user_id = :user_id")
//    List<Follow> findAllFollowerByUserId(@Param("user_id") int userId);

    List<Follow> findAllFollowerByFollowerId(long id);

    @Query(nativeQuery = true,value = "select *  from follow f where f.follower_id = :followerId and f.user_id = :userId")
    Follow findFollowByUserIdAndFollowerId(@Param("userId") Long userId ,@Param("followerId") Long followerId);

}
