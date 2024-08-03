package com.github.qalx.lurker.dtos;

import lombok.Data;

@Data
public class CommentDTO {
    protected String body;
    protected String username;
    protected Long postId;
}
