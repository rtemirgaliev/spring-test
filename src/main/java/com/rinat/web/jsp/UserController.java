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

@Controller
public class UserController {

    private static final Logger log = LogManager.getLogger();

    public static final String CREATE_USER_FORM_VIEW = "users/createUserForm";
    public static final String ALL_USER_LIST_VIEW = "users/allUserList";
    public static final String SERVLET_MAPPING_PREFIX = "/jsp";


    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public String getAllUsers(Map<String, Object> model) {
        model.put("userList", userService.getAllUsers());
        return "users/allUserList";
    }

    @GetMapping(value = "/users/create")
    public String createUser(Map<String, Object> model) {
        model.put("user", new User());
        return CREATE_USER_FORM_VIEW;
    }

    @PostMapping(value = "/users/create")
    public String createUser(Map<String, Object> model, @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            model.put("user", user);
            return CREATE_USER_FORM_VIEW;
        } else {
            try {
                userService.saveUser(user);
            } catch (ConstraintViolationException e) {
                model.put("validationErrors", e.getConstraintViolations());
                return CREATE_USER_FORM_VIEW;
            }
            return "redirect:" + SERVLET_MAPPING_PREFIX + "/users";
        }
    }


}
