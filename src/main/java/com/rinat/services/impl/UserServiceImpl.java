package com.rinat.services.impl;

import com.rinat.entities.User;
import com.rinat.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user) {
        System.out.println("Saving..");
    }
}
