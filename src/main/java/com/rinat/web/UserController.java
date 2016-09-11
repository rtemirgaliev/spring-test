package com.rinat.web;

import com.rinat.entities.User;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
public class UserController {


    @GetMapping(value = "/current")
    public User getCurrentUser() {

        User user = new User("Rinat", "Temirgaliev", 40);

        return user;
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public User createUser(@Valid User user) {


        return user;
    }

}
