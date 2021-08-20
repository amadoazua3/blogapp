package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post.Post;
import com.codeup.blogapp.data.Post.PostsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    private final PostsRepository postsRepository;

    public PostsController(PostsRepository postsrepository){
        this.postsRepository = postsrepository;
    }

    @GetMapping
    private List<Post> getPosts(){
        return postsRepository.findAll();
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id){
        return postsRepository.getById(id);
    }

    @PostMapping
    private void createPost(@RequestBody Post post, Post newPost){

        System.out.println(post.getTitle());
        System.out.println(post.getContent());
        postsRepository.save(newPost);
    }

    @PutMapping({"/{id}"})
    private void updatePost(@PathVariable Long id, @RequestBody Post post, Post postToUpdate){

        System.out.println(post.getTitle());
        System.out.println(post.getContent());
        postsRepository.save(postToUpdate);
    }

    @DeleteMapping({"{id}"})
    private void deletePost(@PathVariable Long id){
        System.out.println("The id deleted was: " + id);
        postsRepository.deleteById(id);
    }

}
