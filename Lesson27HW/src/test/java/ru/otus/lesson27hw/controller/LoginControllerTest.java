package ru.otus.lesson27hw.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
@WithUserDetails
public class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testLoginController() throws Exception {
        this.mockMvc.perform(get("/mylogin"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(view().name("mylogin"))
                .andDo(print());
    }
}