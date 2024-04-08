package com.yevhenkim.communityskillshare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurityController {

    @GetMapping("/secret")
    public ResponseEntity<String> secret() {
        return ResponseEntity.ok("This is a secret message");
    }
}
