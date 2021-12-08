package com.example.assignment.Service;

import com.example.assignment.Entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUser();
    UserEntity loginuser(String username , String password);
    UserEntity saveuser(UserEntity userEntity);
    Boolean userExists(String username);
}
