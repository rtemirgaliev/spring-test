package com.rinat.web;

import com.rinat.entities.User;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping(value = "/users")
public class UserController {


    @GetMapping(value = "/current")
    public User getCurrentUser() {

        User user = new User("Rinat", "Temirgaliev", 40);

        return user;
    }

    @GetMapping(value = "/create")
    public String createUser(Map<String, Object> model) {
        model.put("user", new User());
        return "users/create";
    }

    @PostMapping(value = "/create")
//    @ResponseBody
    public ModelAndView createUser(Map<String, Object> model, @Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            System.out.println("..Validation Error...");
            model.put("user", user);
            return new ModelAndView("/users/create");
        }

        System.out.println("Creating User");

        return new ModelAndView(new RedirectView("/users/current", true, false));
    }

}
