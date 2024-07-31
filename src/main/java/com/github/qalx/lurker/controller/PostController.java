package com.github.qalx.lurker.controller;

import com.github.qalx.lurker.model.Post;
import com.github.qalx.lurker.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Post addPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @RequestMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
            public Post deletePostById(@PathVariable long id) {
        Post post = postRepository.findById(id).get();
        postRepository.delete(post);
        return post;
    }
}
