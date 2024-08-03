package com.github.qalx.lurker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CommentResponseDTO extends CommentDTO{
    Long id;

    public CommentResponseDTO(Long id, String body, String username, Long postId) {
        this.id = id;
        this.body = body;
        this.username = username;
        this.postId = postId;
    }
}
