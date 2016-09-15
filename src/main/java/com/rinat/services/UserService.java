package com.rinat.services;

import com.rinat.entities.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface UserService {

    void saveUser(@NotNull(message = "{validate.userService.saveUser.NotNull}") @Valid User user);

}
