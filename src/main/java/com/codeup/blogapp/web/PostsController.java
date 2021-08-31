package com.codeup.blogapp.web;

import com.codeup.blogapp.Services.EmailService;
import com.codeup.blogapp.data.Post.Post;
import com.codeup.blogapp.data.Post.PostsRepository;
import com.codeup.blogapp.data.User.User;
import com.codeup.blogapp.data.User.UsersRepository;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json", produces = "application/json")
public class PostsController {


    private final PostsRepository postsRepository;

    private final EmailService emailService;

    private final UsersRepository usersRepository;

    public PostsController(PostsRepository postsrepository, EmailService emailService, UsersRepository usersRepository){

        this.postsRepository = postsrepository;
        this.emailService = emailService;
        this.usersRepository = usersRepository;
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
    private void createPost(@RequestBody Post newPost, OAuth2Authentication auth){

        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        String email = auth.getName();
        User user = usersRepository.findByEmail(email).get();
        newPost.setUser(user);
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
