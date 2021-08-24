package com.codeup.blogapp.web;

import com.codeup.blogapp.Services.EmailService;
import com.codeup.blogapp.data.Post.Post;
import com.codeup.blogapp.data.Post.PostsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json", produces = "application/json")
public class PostsController {


    private final PostsRepository postsRepository;

    private final EmailService emailService;

    public PostsController(PostsRepository postsrepository, EmailService emailService){

        this.postsRepository = postsrepository;
        this.emailService = emailService;

    }

    @GetMapping
    private List<Post> getPosts(){
        return postsRepository.findAll();
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id){
        return postsRepository.findById(id).get();
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){

        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        postsRepository.save(newPost);
        emailService.prepareAndSend(newPost, "subject: test email", "this is a test email");
    }

    @PutMapping({"/{id}"})
    private void updatePost(@PathVariable Long id, @RequestBody Post postToUpdate){

        System.out.println(postToUpdate.getTitle());
        System.out.println(postToUpdate.getContent());
        postsRepository.save(postToUpdate);
    }

    @DeleteMapping({"{id}"})
    private void deletePost(@PathVariable Long id){
        System.out.println("The id deleted was: " + id);
        postsRepository.deleteById(id);
    }


}
