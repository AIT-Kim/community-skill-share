package com.yevhenkim.communityskillshare.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    //без аутентификации
    @Test
    public void testSecurityConfig() throws Exception {
        mockMvc.perform(get("/secret"))
                .andExpect(status().isUnauthorized());
    }

    // с аутентификацией
    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void shouldReturnOkForSecretEndpointWithAuth() throws Exception {
        mockMvc.perform(get("/secret"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("This is a secret message")));
    }

}
