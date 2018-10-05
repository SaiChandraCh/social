package com.socials.service;

import com.socials.model.User;
import com.socials.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    UserRepository userRepository;
    User user;

    public String updateRole(ObjectId id, String role) {
        user = userRepository.findById(id);
        userRepository.save(user);
        return "Role Updated";
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User updateUser(ObjectId userId, String fieldName, String value) {
        User user = userRepository.findById(userId);
        switch (fieldName){
            case("firstName"):
                user.setFirstName(value);
                break;
            case("lastName"):
                user.setLastName(value);
                break;
            case("userName"):
                user.setUserName(value);
                break;
            case("email"):
                user.setEmail(value);
                break;
            case("password"):
                user.setPassword(value);
                break;
            case("role"):
                user.setRole(value);
                break;
        }
        userRepository.save(user);
        return user;
    }

    public String deleteUser(ObjectId userId) {
        User user = userRepository.findById(userId);
        userRepository.delete(user);
        return "Deleted";
    }
}
