package com.github.qalx.lurker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CommentResponseDTO extends CommentDTO{
    Long id;

    public CommentResponseDTO(Long id, String body, Long userId, Long postId) {
        this.id = id;
        this.body = body;
        this.userId = userId;
        this.postId = postId;
    }
}
