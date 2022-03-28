package com.codegym.tiktok.userPackage.repository;

import com.codegym.tiktok.userPackage.model.Follow;
import com.codegym.tiktok.userPackage.model.Liked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepo extends JpaRepository<Liked ,Long> {
    List<Liked> findAllUserByPosts_Id(long id);
    @Query(nativeQuery = true,value = "select *  from liked l where l.posts_id = :postsId and l.user_id = :userId")
    Liked unlike( @Param("postsId") Long postsId ,@Param("userId") Long userId );
}
