package com.rinat.web;

import com.rinat.entities.User;
import com.rinat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

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

//        if (errors.hasErrors()) {
//            System.out.println("..Validation Error...");
//            model.put("user", user);
//            return new ModelAndView("/users/create");
//        }

        System.out.println("Create User Controller");

        try {
            userService.saveUser(user);
        } catch (ConstraintViolationException e) {
            System.out.println("catched errors");
            model.put("validationErrors", e.getConstraintViolations());
            return new ModelAndView("/users/create");
        }



        return new ModelAndView(new RedirectView("/users/current", true, false));
    }

}
