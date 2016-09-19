package com.rinat.web.jsp;

import com.rinat.entities.User;
import com.rinat.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "users")
public class UserController {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    UserService userService;

    @GetMapping(value = "")
    public String getAllUsers(Map<String, Object> model) {

        model.put("userList", userService.getAllUsers());
        return "/users/all";
    }

    @GetMapping(value = "create")
    public ModelAndView createUser() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("user", new User());
        mv.setViewName("/users/create");
        return mv;
    }

    @PostMapping(value = "create")
    public ModelAndView createUser(Map<String, Object> model, @Valid User user, Errors errors) {


        if (errors.hasErrors()) {
            model.put("user", user);
            return new ModelAndView("/users/create");
        }

        try {
            userService.saveUser(user);
        } catch (ConstraintViolationException e) {
            model.put("validationErrors", e.getConstraintViolations());

            return new ModelAndView("/users/create");
        }

        return new ModelAndView(new RedirectView("/users", true, false));
    }

}
