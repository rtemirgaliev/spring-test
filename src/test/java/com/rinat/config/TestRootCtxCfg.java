package com.rinat.config;

import com.rinat.services.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestRootCtxCfg {

    @Bean
    public UserService userService() {
        return Mockito.mock(com.rinat.services.impl.UserServiceImpl.class);
    }
}
