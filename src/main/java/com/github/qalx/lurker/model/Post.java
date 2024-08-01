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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
