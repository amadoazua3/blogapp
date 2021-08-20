package com.codeup.blogapp.data.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public class PostRepository {

    public interface PostsRepository extends JpaRepository<Post, Long> {
        Post findByTitle(String title); // select * from posts where title = ?
        Post findFirstByTitle(String title); // select * from posts where title = ? limit 1
    }

}
