package com.example.assignment.Service;

import com.example.assignment.Entity.UserEntity;
import com.example.assignment.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<UserEntity> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public UserEntity loginuser(String username, String password) {
        UserEntity userEntity = userRepo.findByUsernameAndPassword(username , password);
        return userEntity;
    }

    @Override
    public UserEntity saveuser(UserEntity userEntity) {
        if (userEntity != null) {
            return userRepo.save(userEntity);
        }
        else
        {
            return null;
        }
    }

    @Override
    public Boolean userExists(String username) {
        if (userRepo.findByUsername(username) == null)
        {
            return true;
        }
        else {
            return false;
        }
    }


}













