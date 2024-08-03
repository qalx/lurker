package com.github.qalx.lurker.service;

import com.github.qalx.lurker.dtos.CommentDTO;
import com.github.qalx.lurker.dtos.CommentResponseDTO;
import com.github.qalx.lurker.model.Comment;
import com.github.qalx.lurker.model.Post;
import com.github.qalx.lurker.model.User;
import com.github.qalx.lurker.repository.CommentRepository;
import com.github.qalx.lurker.repository.PostRepository;
import com.github.qalx.lurker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    public CommentDTO addComment(Long postId, CommentDTO commentDTO) {
        Post post = postRepository.findById(postId).get();
        Long userId = userRepository.findByName(commentDTO.getUsername()).getId();
        User user = userRepository.findById(userId).get();
        Comment comment = new Comment(commentDTO.getBody(), user, post);
        commentRepository.save(comment);
        return commentDTO;
    }

    public List<CommentResponseDTO> getAllComments() {
        return commentRepository.findAll().stream().map(comment -> new CommentResponseDTO(
                comment.getId(),
                comment.getBody(),
                comment.getUser().getName(),
                comment.getPost().getId()
        )).collect(Collectors.toList());
    }

    public CommentResponseDTO findById(Long commentId) {
        Comment comment = commentRepository.findById(commentId).get();
        return new CommentResponseDTO(comment.getId(), comment.getBody(), comment.getUser().getName(),
                comment.getPost().getId());
    }
}
