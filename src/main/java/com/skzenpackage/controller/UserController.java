package com.skzenpackage.controller;

import com.skzenpackage.security.SiteUser;
import com.skzenpackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("intraweb")
@RestController
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody SiteUser siteUser) {
        userService.registerNewUser(siteUser);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody SiteUser siteUser) {
        return new LoginResponse(userService.validateUser(siteUser));
    }

}
