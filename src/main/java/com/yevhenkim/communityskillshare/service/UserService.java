package com.yevhenkim.communityskillshare.service;

import com.yevhenkim.communityskillshare.model.User;
import com.yevhenkim.communityskillshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Метод для регистрации нового пользователя
    public User registerUser(User user) {
        // Здесь может быть логика проверки и хеширования пароля
        return userRepository.save(user);
    }

    // поиск пользователя по id или email
}

