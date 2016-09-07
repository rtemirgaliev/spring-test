package com.rinat.web;

import com.rinat.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/users")
public class UserController {


    @GetMapping(value = "/rinat")
    @ResponseBody
    public User getCurrentUser() {

        return new User("Rinat", "Temirgaliev", 40);

    }
}
