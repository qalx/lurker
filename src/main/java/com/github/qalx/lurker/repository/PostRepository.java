package com.github.qalx.lurker.repository;

import com.github.qalx.lurker.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
