package com.assignment1.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAPI {

    @RequestMapping("/test")
    @CrossOrigin
    public String test() {
        return "Test";
    }

}
