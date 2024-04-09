package com.yevhenkim.communityskillshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Community Skill Share!");
        List<String> features = Arrays.asList(
                "Регистрация и вход в систему",
                "Регистрация и управление профилями пользователей",
                "Публикация и поиск предложений о навыках",
                "Управление сессиями обмена навыкам",
                "Отзывы и рейтинги");
        model.addAttribute("features", features);
        return "index";
    }

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "Man");
        return "greeting";
    }

/*
    @GetMapping("/login")
    public String login() {
        return "index";
    }

 */
}
