package com.yevhenkim.communityskillshare.controller;

import com.yevhenkim.communityskillshare.dto.AccountInfo;
import com.yevhenkim.communityskillshare.dto.LoginRequest;
import com.yevhenkim.communityskillshare.dto.LoginResponse;
import com.yevhenkim.communityskillshare.dto.ProfileInfo;
import com.yevhenkim.communityskillshare.model.User;
import com.yevhenkim.communityskillshare.repository.UserRepository;
import com.yevhenkim.communityskillshare.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ProfileInfo> getUserById(@PathVariable Long userId, HttpServletRequest request) {
        String currentUserId = userService.getUserFromRequest(request);
        if(currentUserId == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        User user = userService.findUserById(userId);
        ProfileInfo userInfo = new ProfileInfo();
        userInfo.setUsername(user.getName());
        userInfo.setEmail(user.getEmail());
        return user != null ? ResponseEntity.ok(userInfo) : ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = userService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/me")
    public ResponseEntity<AccountInfo> getMyProfile(HttpServletRequest request) {
        String currentUserId = userService.getUserFromRequest(request);
        if(currentUserId == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        User user = userService.findUserById(currentUserId);
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setUsername(user.getName());
        accountInfo.setEmail(user.getEmail());


        return user != null ? ResponseEntity.ok(accountInfo) : ResponseEntity.notFound().build();
    }

}

