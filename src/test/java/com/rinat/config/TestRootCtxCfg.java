package com.rinat.config;

import com.rinat.services.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestRootCtxCfg {

    /**
     * Initializes the mock UserService bean in the test application context.
     * Masks the real UserService bean in the root context.
      * @return
     */
    @Bean
    public UserService userService() {
        return Mockito.mock(com.rinat.services.impl.UserServiceImpl.class);
    }
}
