package com.rinat.web;

import com.rinat.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/users")
public class UserController {


    @GetMapping(value = "/rinat")
    @ResponseBody
    public ModelAndView getCurrentUser() {

        User user = new User("Rinat", "Temirgaliev", 40);
        ModelAndView mv = new ModelAndView();

        mv.addObject(user);
        mv.setViewName("users");

        return mv;

    }
}
