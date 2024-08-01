package com.github.qalx.lurker.controller;

import com.github.qalx.lurker.model.Post;
import com.github.qalx.lurker.repository.PostRepository;
import com.github.qalx.lurker.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("user/{userId}/post")
public class PostController {
    UserRepository userRepository;
    PostRepository postRepository;

    public PostController(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    // GET /user/{userId}/post
    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // GET /user/{userId}/post/{postId}
    @GetMapping(value = "{postId}")
    public Post getPost(@PathVariable Long postId) {
        return postRepository.findById(postId).get();
    }

    // POST /user/{userId}/post
    @PostMapping
    public Post addPost(@PathVariable Long userId, @RequestBody Post post) {
        post.setUser(userRepository.findById(userId).get());
        System.out.println(userRepository.findById(userId).get().getName());
        return postRepository.save(post);
    }

    // DELETE /user/{userId}/post/{postId}
    @DeleteMapping(value = "{postId}")
    public Post deletePostById(@PathVariable long postId) {
        Post post = postRepository.findById(postId).get();
        postRepository.delete(post);
        System.out.println("test");
        return post;
    }
}
