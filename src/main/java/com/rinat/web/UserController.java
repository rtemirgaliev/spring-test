package com.rinat.web;

import com.rinat.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
public class UserController {


    @GetMapping(value = "/rinat")
    public ModelAndView getCurrentUser() {

        User user = new User("Rinat", "Temirgaliev", 40);
        ModelAndView mv = new ModelAndView();

        mv.addObject(user);
        mv.setViewName("users");

        return mv;
    }

    @PostMapping(value = "/create")
    public ModelAndView createUser(@Valid User user) {

        System.out.println(user);

        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("created");
        return mv;
    }

}
