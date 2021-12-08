package com.example.assignment.Repository;

import com.example.assignment.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsernameAndPassword(String username , String password);
    UserEntity findByUsername(String username);
}
