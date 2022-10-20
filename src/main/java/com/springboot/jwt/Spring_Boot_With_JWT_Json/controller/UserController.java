package com.springboot.jwt.Spring_Boot_With_JWT_Json.controller;


import com.springboot.jwt.Spring_Boot_With_JWT_Json.model.User;
import com.springboot.jwt.Spring_Boot_With_JWT_Json.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public String savingUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping ("/getUserDetails/{userid}")
    public User getUserDetails(@PathVariable ObjectId userid){
//    public User getUserDetails(HttpServletRequest httpServletRequest){
        //ObjectId userid=(ObjectId) httpServletRequest.getAttribute("userId");
        return userService.getUser(userid);
    }
}
