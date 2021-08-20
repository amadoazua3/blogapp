package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category.Category;
import com.codeup.blogapp.data.Post.Post;
import com.codeup.blogapp.data.User.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    User user = new User("testing");
    List<Category> categories = new ArrayList<>(){{
        add(new Category(1L, "Spring boot"));
        add(new Category(2L, "Why JS views makes my head hurt"));
    }};

    @GetMapping
    private List<Post> getPosts(){


        return new ArrayList<Post>(){{
           add(new Post(1L, "A new Post", "This is a brilliant posts. 10/10", user, categories));
           add(new Post(2L, "A new Post", "This is a brilliant posts. 11/10", user, categories));
           add(new Post(3L, "A new Post", "This is a brilliant posts. 12/10", user, categories));

        }};
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id){

        User user = new User(1L, "testing", "testing@email.com", "testing123", User.Role.USER,null);

        // api/posts/1
        if(id == 1){
            return new Post(1L, "A new Post", "This is a brilliant posts. 10/10", user, categories);
        }else{
            return null;
        }
    }

    @PostMapping
    private void createPost(@RequestBody Post post){

        System.out.println(post.getTitle());
        System.out.println(post.getContent());

    }

    @PutMapping({"/{id}"})
    private void updatePost(@PathVariable Long id, @RequestBody Post post){

        System.out.println(post.getTitle());
        System.out.println(post.getContent());
    }

    @DeleteMapping({"{id}"})
    private void deletePost(@PathVariable Long id){
        System.out.println("The id deleted was: " + id);
    }

}
