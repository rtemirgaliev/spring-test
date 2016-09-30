package com.rinat.web.jsp;

import com.rinat.entities.User;
import com.rinat.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { com.rinat.config.TestRootCtxCfg.class, com.rinat.config.RootCtxCfg.class, com.rinat.config.JspServletCtxCfg.class })
public class UserControllerTests {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    private MockMvc mockMvc;
    private User rinat;
    private static final int TEST_USER_ID = 0;

    @Before
    public void setup() {
            this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        rinat = new User("Rinat", "Temirgaliev", 40);
        userService.saveUser(rinat);
        given(this.userService.findById(TEST_USER_ID)).willReturn(rinat);
    }

    @Test
    public void testGetAllUserList() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("userList"))
                .andExpect(view().name(UserController.ALL_USER_LIST_VIEW));
    }
    @Test
    public void testInitCreateUserForm() throws Exception {
        mockMvc.perform(get("/users/create"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("user"))
                .andExpect(view().name(UserController.CREATE_USER_FORM_VIEW));
    }
    @Test
    public void testProcessCreateUserFormSuccess() throws Exception {
        mockMvc.perform(post("/users/create")
                .param("firstName", "Rinat")
                .param("lastName", "Temirgaliev")
                .param("age", "40")
        )
                .andExpect(status().is3xxRedirection());
    }
    @Test
    public void testProcessCreateUserFormErrors() throws Exception {
        mockMvc.perform(post("/users/create")
                .param("firstName", "")
                .param("lastName", "")
                .param("age", "")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("user"))
                .andExpect(model().attributeHasFieldErrors("user", "firstName"))
                .andExpect(model().attributeHasFieldErrors("user", "lastName"))
                .andExpect(model().attributeHasFieldErrors("user", "age"))
                .andExpect(view().name(UserController.CREATE_USER_FORM_VIEW));
    }





}
