package com.codegym.tiktok.userPackage.service.imp;

import com.codegym.tiktok.userPackage.dto.Search;
import com.codegym.tiktok.userPackage.model.Follow;
import com.codegym.tiktok.userPackage.model.Posts;
import com.codegym.tiktok.userPackage.model.User;
import com.codegym.tiktok.userPackage.repository.FollowRepo;
import com.codegym.tiktok.userPackage.repository.PostRepo;
import com.codegym.tiktok.userPackage.repository.UserRepo;
import com.codegym.tiktok.userPackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    FollowRepo followRepo;


    @Override
    public Page<User> findAll(Pageable page) {
        return userRepo.findAll(page);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> search(Search search) {
        String name = search.getName();
        String content = search.getName();
        return userRepo.findUser(name , content);
    }

//    @Override
//    public List<Follow> findAllFollowerByUserId(int id) {
//        return followRepo.findAllFollowerByUserId(id);
//    }


//    @Override
//    public User findUserById(Long id) {
//        return userRepo.findUserById(id);
//    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
