package com.socials.service;

import com.socials.model.User;
import com.socials.repository.UserRepository;
import com.socials.security.jwt.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtGenerator jwtGenerator;
    public void createUser(User user) {
        userRepository.insert(user);
    }

    public String login(String userName, String password) {
        User user = userRepository.findUsersByUserNameAndPassword(userName,password);
        if(user != null){
            jwtGenerator.generate(user);
            return user.getUserName()+" Login Success";
        }else{
            return "User not found";
        }
    }

    public String uploadFile(MultipartFile file) {
        try {
            if(fileTypeIsValid(file)){
                byte[] bytes = file.getBytes();
                Path path = Paths.get("/home/sai/Codebase/sai/codebase/workarea/social/src/main/resources/images" + file.getOriginalFilename());
                Files.write(path, bytes);
            }else{
                return "Invalid file input";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "uploaded";
    }

    private boolean fileTypeIsValid(MultipartFile file) {
        return file.getContentType().endsWith("xml");
    }

}
