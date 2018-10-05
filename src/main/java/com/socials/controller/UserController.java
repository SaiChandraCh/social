package com.socials.controller;

import com.socials.model.User;
import com.socials.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("socials")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        userService.createUser(user);
        return user;
    }

    @RequestMapping(value = "/{userName}/upload",method = RequestMethod.PUT)
    public String upload(@RequestParam("file") MultipartFile file,
                        @PathVariable("userName") String userName){
        return userService.uploadFile(file);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String getUser(@RequestParam("userName") String userName,
                          @RequestParam("password") String password){
        return userService.login(userName,password);
    }
//    ----------------------------- Test ----------------------------
//    @RequestMapping(value = "/{message}",method = RequestMethod.GET)
//    public String sample(@PathVariable String message){
//        return message;
//    }

}
