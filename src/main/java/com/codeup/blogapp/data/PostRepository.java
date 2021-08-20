package com.codeup.blogapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

public class PostRepository {

    public interface PostsRepository extends JpaRepository<Post, Long> {

    }

}
