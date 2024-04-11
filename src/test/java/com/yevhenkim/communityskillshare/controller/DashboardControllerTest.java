package com.yevhenkim.communityskillshare.controller;

import com.yevhenkim.communityskillshare.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = DashboardController.class)
@Import({SecurityConfig.class})
public class DashboardControllerTest {

    @Autowired
    private MockMvc mockMvc;
//TODO
/*
    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void secretShouldBeAccessibleByAnyAuthenticatedUser() throws Exception {
        mockMvc.perform(get("/admin/secret"))
                .andExpect(status().isOk())
                .andExpect(content().string("Secret information"));
    }
*/
    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_ADMIN"})
    public void dashboardShouldBeAccessibleByAdmin() throws Exception {
        mockMvc.perform(get("/admin/dashboard"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"Welcome to the Admin Dashboard!\",\"description\":\"Here you can manage your application.\"}"));
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void dashboardShouldNotBeAccessibleByNonAdmin() throws Exception {
        mockMvc.perform(get("/admin/dashboard"))
                .andExpect(status().isForbidden());
    }
}
