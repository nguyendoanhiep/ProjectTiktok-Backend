package com.codegym.tiktok.securityPackage.service;
import com.codegym.tiktok.userPackage.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String name); //Tim kiem User co ton tai trong DB khong?
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User save(User user);
    Optional<User> findById(Long id);
}
