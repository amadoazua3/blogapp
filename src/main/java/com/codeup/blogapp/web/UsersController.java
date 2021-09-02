package com.codeup.blogapp.web;

import com.codeup.blogapp.data.User.User;
import com.codeup.blogapp.data.User.UsersRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json", produces = "application/json")
public class UsersController {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersController(UsersRepository usersRepository, PasswordEncoder passwordEncoder){

        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    private List<User> getUsers(){

        return usersRepository.findAll();
    }

    @GetMapping("{id}")
    private User getUserById(@PathVariable Long id){
        return usersRepository.getById(id);
    }

    @GetMapping("/me")
    private User getCurrentUser(OAuth2Authentication auth){
        String email = auth.getName();
        return usersRepository.findByEmail(email).get();
    }

    @PostMapping("/create")
    @PreAuthorize("!hasAuthority('USER') || (#oldPassword != null && !#oldPassword.isEmpty())")
    public void createUser(@RequestBody User user){
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    @PutMapping({"/{id}"})
    private void updateUser(@PathVariable Long id, @RequestBody User user){

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        usersRepository.save(user);
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
        return usersRepository.findByEmail(email).get();
    }

    @PutMapping({"{id}/updatePassword"})
    @PreAuthorize("!hasAuthority('User') || (#oldPassword != null && !#oldPassword.isEmpty())")
    public void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){
        if(!newPassword.equals(oldPassword)){
            System.out.println("Password for id: " + id + " has been updated!");
            System.out.println("Old password: " + oldPassword);
            System.out.println("New password: " + newPassword);
            User user = usersRepository.getById(id);
            user.setPassword(newPassword);
            usersRepository.save(user);
        }
    }

}
