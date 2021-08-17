package com.codeup.blogapp.web;

import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    @GetMapping
    private List<User> getUsers(){
        return new ArrayList<User>(){{
            add(new User(1L, "amuro.ray79", "rx782@email.com", "Universal0079", User.Role.USER));
            add(new User(2L, "hathaway.noa", "rx105@email.com", "Hathaway0105", User.Role.USER));
            add(new User(3L, "heero.yuy", "wingzero@email.com", "EndlessWaltz00", User.Role.USER));
        }};
    }

    @GetMapping("{id}")
    private User getUserById(@PathVariable Long id){
        // api/posts/1
        if(id == 1){
            return new User(1L, "amuro.ray79", "rx782@email.com", "Universal0079", User.Role.USER);
        }else{
            return null;
        }
    }

    @PostMapping
    private void createUser(@RequestBody User user){

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());

    }

    @PutMapping({"/{id}"})
    private void updateUser(@PathVariable Long id, @RequestBody User user){

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
    }

    @DeleteMapping({"{id}"})
    private void deleteUser(@PathVariable Long id){
        System.out.println("The id deleted was: " + id);
    }


}
