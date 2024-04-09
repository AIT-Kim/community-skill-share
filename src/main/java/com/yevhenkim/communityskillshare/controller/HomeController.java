package com.yevhenkim.communityskillshare.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/api/home")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to Community Skill Share!");
        List<String> features = Arrays.asList(
                "Регистрация и вход в систему",
                "Регистрация и управление профилями пользователей",
                "Публикация и поиск предложений о навыках",
                "Управление сессиями обмена навыкам",
                "Отзывы и рейтинги");
        response.put("features", features);
        return response;
    }

    @GetMapping("/")
    public String homelocal() {
        return "index";
    }    



    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "Man");
        return "greeting";
    }

}
