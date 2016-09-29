package com.rinat.web.rest;

import com.rinat.entities.User;
import com.rinat.services.UserService;
import com.rinat.web.exception.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger log = LogManager.getLogger();
    @Autowired
    UserService userService;

    @GetMapping(value = "")
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @PostMapping(value = "/create")
    public User createUser(@Valid User user) {

        userService.saveUser(user);

        return user;
    }




}
