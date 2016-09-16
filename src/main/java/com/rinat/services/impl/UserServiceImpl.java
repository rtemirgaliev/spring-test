package com.rinat.services.impl;

import com.rinat.entities.User;
import com.rinat.services.UserService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @NotNull
    List<User> userList = new ArrayList<>();

    @Override
    public void saveUser(User user) {
        userList.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }
}
