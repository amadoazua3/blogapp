package com.codeup.blogapp.data.User;

import com.codeup.blogapp.data.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository {

    public interface UsersRepository extends JpaRepository<User, Long> {

    }
}
