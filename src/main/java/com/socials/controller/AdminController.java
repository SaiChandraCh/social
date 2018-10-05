package com.socials.controller;

import com.socials.model.User;
import com.socials.service.AdminService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("socials/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public String updateRole(@RequestParam("id") ObjectId id, @RequestParam String role){
        return adminService.updateRole(id,role);
    }


    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    public User updateUser(@RequestParam("id") ObjectId userId,
                           @RequestParam("fieldName") String fieldName,
                           @RequestParam("value") String value){
        return adminService.updateUser(userId,fieldName,value);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.PUT)
    public String deleteUser(@RequestParam("id") ObjectId userId){
        return adminService.deleteUser(userId);
    }

    @RequestMapping(value = "/getUsers")
    public List<User> getUsers(){
        return adminService.getAllUsers();
    }
}
