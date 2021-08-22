package com.codeup.blogapp.web;

import com.codeup.blogapp.data.User.User;
import com.codeup.blogapp.data.User.UsersRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @GetMapping
    private List<User> getUsers(){
       return usersRepository.findAll();
    }

    @GetMapping("{id}")
    private User getUserById(@PathVariable Long id){
        return usersRepository.getById(id);
    }

    @PostMapping
    private void createUser(@RequestBody User user, User newPost){

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        usersRepository.save(newPost);
    }

    @PutMapping({"/{id}"})
    private void updateUser(@PathVariable Long id, @RequestBody User user, User postToUpdate){

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        usersRepository.save(postToUpdate);
    }

    @DeleteMapping({"{id}"})
    private void deleteUser(@PathVariable Long id){
        System.out.println("The id deleted was: " + id);
        usersRepository.deleteById(id);
    }

    @PostMapping({"{id}"})
    private void findById(@PathVariable Long id){
        System.out.println("Id: " + id);
        usersRepository.findById(id);
    }

    @PostMapping("/findByUsername")
    private User findByUsername(@RequestParam String username){
        System.out.println("Username: " + username);
        return usersRepository.findByUsername(username);
    }

    @PostMapping("/findByEmail")
    private User findByEmail(@RequestParam String email){
        System.out.println("E-mail: " + email);
        return usersRepository.findByEmail(email);
    }

    @PutMapping({"{id}/updatePassword"})
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){
        if(!newPassword.equals(oldPassword)){
            System.out.println("Password for id: " + id + " has been updated!");
            System.out.println("Old password: " + oldPassword);
            System.out.println("New password: " + newPassword);
            usersRepository.updatePassword(id);
        }
    }

}
