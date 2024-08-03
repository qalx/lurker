package com.github.qalx.lurker.model;

import jakarta.persistence.*;

@Entity
@Table(name="comments")
public class Comment {
    public Comment(String body, User user, Post post) {
        this.id = id;
        this.body = body;
        this.user = user;
        this.post = post;
    }

    @Id
    @GeneratedValue
    private Long id;

    public String body;
    @ManyToOne
    User user;
    @ManyToOne
    Post post;

    public Comment() {

    }

    public Long getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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
