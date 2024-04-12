package com.yevhenkim.communityskillshare.service;

import com.yevhenkim.communityskillshare.dto.LoginRequest;
import com.yevhenkim.communityskillshare.dto.LoginResponse;
import com.yevhenkim.communityskillshare.model.Skill;
import com.yevhenkim.communityskillshare.model.User;
import com.yevhenkim.communityskillshare.repository.UserRepository;
import com.yevhenkim.communityskillshare.secutiry.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    public User registerUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    public User findUserByUsername(String name) {
        return userRepository.findByName(name).orElse(null);
    }

    public List<Skill> getSkillsByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return new ArrayList<>(userOptional.get().getSkills());
        } else {
            return Collections.emptyList();
        }
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }
        
        String jwt = tokenProvider.generateToken(user);

        var response = new LoginResponse();
        response.setUsername(user.getName());
        response.setEmail(user.getEmail());
        response.setJwtToken(jwt);

        return response;
    }


}

