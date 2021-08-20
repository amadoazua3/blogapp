package com.codeup.blogapp.web;

import com.codeup.blogapp.data.User.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    User user = new User(1L, "testing", "testing@email.com", "testing123", User.Role.USER,null);

    @GetMapping
    private List<User> getUsers(){
        return new ArrayList<User>(){{
            add(new User(1L, "amuro.ray79", "rx782@email.com", "Universal0079", User.Role.USER, null));
            add(new User(2L, "hathaway.noa", "rx105@email.com", "Hathaway0105", User.Role.USER, null));
            add(new User(3L, "heero.yuy", "wingzero@email.com", "EndlessWaltz00", User.Role.USER, null));
        }};
    }

    @GetMapping("{id}")
    private User getUserById(@PathVariable Long id){

        // api/posts/1
        if(id == 1){
            return new User(1L, "amuro.ray79", "rx782@email.com", "Universal0079", User.Role.USER, null);
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

    @PostMapping({"{id}"})
    private void findById(@PathVariable Long id){
        System.out.println("Id: " + id);
    }

    @PostMapping("/findByUsername")
    private void findByUsername(@RequestParam String username){
        System.out.println("Username: " + username);
    }

    @PostMapping("/findByEmail")
    private void findByEmail(@RequestParam String email){
        System.out.println("E-mail: " + email);
    }

    @PutMapping({"{id}/updatePassword"})
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){
        if(!newPassword.equals(oldPassword)){
            System.out.println("Password for id: " + id + " has been updated!");
            System.out.println("Old password: " + oldPassword);
            System.out.println("New password: " + newPassword);
        }
    }

}
