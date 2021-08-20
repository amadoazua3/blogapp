package com.codeup.blogapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository {

    public interface UsersRepository extends JpaRepository<User, Long> {

    }
}
