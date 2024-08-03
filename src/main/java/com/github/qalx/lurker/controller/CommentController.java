package com.github.qalx.lurker.controller;

import com.github.qalx.lurker.dtos.CommentDTO;
import com.github.qalx.lurker.dtos.CommentResponseDTO;
import com.github.qalx.lurker.model.Comment;
import com.github.qalx.lurker.model.Post;
import com.github.qalx.lurker.repository.CommentRepository;
import com.github.qalx.lurker.repository.PostRepository;
import com.github.qalx.lurker.repository.UserRepository;
import com.github.qalx.lurker.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("posts/{postId}/comments")
public class CommentController {
    UserRepository userRepository;
    PostRepository postRepository;
    CommentRepository commentRepository;

    CommentService commentService;

    public CommentController(UserRepository userRepository, PostRepository postRepository,
                             CommentRepository commentRepository, CommentService commentService) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.commentService = commentService;
    }

    // GET /posts/{postId}/comments
    @GetMapping
    public List<CommentResponseDTO> getAllComments() {
        return commentService.getAllComments();
    }

    // GET /posts/{postId}/comments/{commentId}
    @GetMapping(value = "{commentId}")
    public CommentResponseDTO getComment(@PathVariable Long commentId) {
        return commentService.findById(commentId);
    }

    // POST /posts/{postId}/comments
    @PostMapping
    public CommentDTO addComment(@PathVariable Long postId, @RequestBody CommentDTO commentDTO) {
        return commentService.addComment(postId, commentDTO);
    }

    // DELETE /posts/{postId}/comments/{commentId}
    @DeleteMapping(value = "{commentId}")
    public Comment deletePostById(@PathVariable long postId) {
        Comment comment = commentRepository.findById(postId).get();
        commentRepository.delete(comment);
        return comment;
    }
}
