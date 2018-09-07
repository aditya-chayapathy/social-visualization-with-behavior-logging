package com.assignment1.controller;

import com.assignment1.pojo.User;
import com.assignment1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserAPI {

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    @CrossOrigin
    public String test() {
        return "Test";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @CrossOrigin
    public User addUser(@RequestParam(value = "name") String name,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "address") String address) {
        return userService.addUser(name, password, address);
    }

    @RequestMapping(value = "/removeUser", method = RequestMethod.POST)
    @CrossOrigin
    public User removeUser(@RequestParam(value = "name") String name,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "address") String address) {
        return userService.removeUser(name, password, address);
    }

    @RequestMapping(value = "/checkIfUserExists")
    @CrossOrigin
    public Boolean checkIfUserExists(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "password") String password,
                                     @RequestParam(value = "address") String address) {
        return userService.checkIfUserExists(name, password, address);
    }

    @RequestMapping(value = "/getAllUsers")
    @CrossOrigin
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
