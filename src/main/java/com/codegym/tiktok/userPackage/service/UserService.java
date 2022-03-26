package com.codegym.tiktok.userPackage.service;

import com.codegym.tiktok.userPackage.dto.Search;
import com.codegym.tiktok.userPackage.model.Comment;
import com.codegym.tiktok.userPackage.model.Follow;
import com.codegym.tiktok.userPackage.model.Posts;
import com.codegym.tiktok.userPackage.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    Page<User> findAll(Pageable page);
    User save(User user);
    void delete(Long id);
    User findById(Long id );
//    List<Follow> findAllFollowerByUserId(int id);
    List<User> search(Search search);



}
