package com.github.qalx.lurker.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    User user;
    public String body;
}
