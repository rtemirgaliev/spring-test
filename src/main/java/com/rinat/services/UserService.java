package com.rinat.services;

import com.rinat.entities.User;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface UserService {

    User findById(int id);

    void saveUser(@NotNull(message = "{validate.userService.saveUser.NotNull}") @Valid User user);

    List<User> getAllUsers();

}
