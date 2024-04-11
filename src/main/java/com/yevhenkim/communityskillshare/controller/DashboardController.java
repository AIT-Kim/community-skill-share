package com.yevhenkim.communityskillshare.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
@RequestMapping("/admin")
public class DashboardController {

    @GetMapping("/secret")
    public ResponseEntity<String> secret() {
        return ResponseEntity.ok("Secret information");
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public DashboardResponse dashboard() {
        DashboardResponse response = new DashboardResponse("Welcome to the Admin Dashboard!", "Here you can manage your application.");
        return response;
    }

    private static class DashboardResponse {
        private String message;
        private String description;

        public DashboardResponse(String message, String description) {
            this.message = message;
            this.description = description;
        }

        public void setMessage(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }

        public String getDescription() {
            return description;
        }
    }
}
