package com.codegym.tiktok.userPackage.repository;

import com.codegym.tiktok.userPackage.model.Comment;
import com.codegym.tiktok.userPackage.model.Posts;
import com.codegym.tiktok.userPackage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User , Long> {
//        @Query( nativeQuery = true,value = "SELECT * FROM tiktok.user join tiktok.posts on user.id = users_id where user.id = :id")


        @Query(nativeQuery = true,value = "select * from user u join posts p on p.user_id = u.id where u.name like \"%w%\" or p.content like \"%a%\"")
        List<User> findUser(@Param("name") String name);

}