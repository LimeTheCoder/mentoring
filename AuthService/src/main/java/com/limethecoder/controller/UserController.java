package com.limethecoder.controller;

import com.limethecoder.model.User;
import com.limethecoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/info")
    public Principal getUserInfo(Principal principal) {
        return principal;
    }

    @RequestMapping(method = RequestMethod.POST)
    public User registerUser(@RequestBody User user) {
        return userService.create(user);
    }
}
