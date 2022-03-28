package com.codegym.tiktok.userPackage.controller;

import com.codegym.tiktok.userPackage.dto.Search;
import com.codegym.tiktok.userPackage.model.Comment;
import com.codegym.tiktok.userPackage.model.Follow;
import com.codegym.tiktok.userPackage.model.Posts;
import com.codegym.tiktok.userPackage.model.User;
import com.codegym.tiktok.userPackage.service.CommentService;
import com.codegym.tiktok.userPackage.service.FollowService;
import com.codegym.tiktok.userPackage.service.PostService;
import com.codegym.tiktok.userPackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @Autowired
    FollowService followService;


    @GetMapping("/home/{page}")
    public ResponseEntity<Page<User>> findALl(@PathVariable int page) {
        return new ResponseEntity(userService.findAll(PageRequest.of(page, 5)), HttpStatus.OK);
    }

    @GetMapping("/show")
    public ResponseEntity<List<Posts>> findALlPost() {
        return new ResponseEntity(postService.findAll(), HttpStatus.OK);
    }



    @GetMapping("/comment/{idPosts}")
    public List<Comment> getListComment(@PathVariable long idPosts){
        return  commentService.findAllByPostId(idPosts);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return new ResponseEntity(userService.findById(id), HttpStatus.OK);
    }



    @GetMapping("/post/{id}")
    public ResponseEntity<Posts> findByIdPost(@PathVariable Long id) {
        return new ResponseEntity(postService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create/post/{id}")
    public ResponseEntity<Posts> createPost(@RequestBody Posts posts ,@PathVariable Long id){
        User user = userService.findById(id);
        posts.setUser(user);
        return new ResponseEntity(postService.save(posts), HttpStatus.OK);
    }

    @GetMapping("/post/show/{idUser}")
    public List<Posts> getListPost(@PathVariable long idUser){
        return  postService.findAllByUserId(idUser);
    }

    @PostMapping("/create/comment")
    public void saveComment(@RequestBody Comment comment){
        commentService.save(comment);
    }

    @GetMapping("/follow/{id}")
    public ResponseEntity<List<Follow>> findAllFollower(@PathVariable Long id){
        return new ResponseEntity(followService.findAllFollowerByUserId(id),HttpStatus.OK);
    }

    @PostMapping("/new/follow")
    public  ResponseEntity saveFollower(@RequestBody Follow follow){
            followService.save(follow);
        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping("/delete/unfollow/{userId}/{followerId}")
    public ResponseEntity delete(@PathVariable Long userId,@PathVariable Long followerId){
        followService.unFollow(userId,followerId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/edit/user/{id}")
    public ResponseEntity<User> edit(@PathVariable Long id , @RequestBody User user) {
        user.setId(id);
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping ("/search")
    public ResponseEntity<List<User>> findAllByFilters(@RequestBody Search search){
        return new ResponseEntity(userService.search(search), HttpStatus.OK);
    }

    @GetMapping("/show/follow/user/{id}")
    public ResponseEntity<List<Follow>> findALlUserByFollowerId( @PathVariable  Long id) {
        return new ResponseEntity(followService.findAllUserByFollowerId(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/posts/{id}")
    public ResponseEntity deletePost(@PathVariable Long id){
        postService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/comment/{id}")
    public ResponseEntity deleteComment(@PathVariable Long id){
        commentService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
