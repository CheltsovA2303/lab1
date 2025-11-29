package com.example.lab1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Добро пожаловать в Lab1! Время сервера: " + LocalDateTime.now();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Привет из Spring Boot Lab1!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name", defaultValue = "Студент") String name) {
        return String.format("Привет, %s! Это лабораторная работа 1.", name);
    }

    @GetMapping("/info")
    public String info() {
        return """
            <h2>Информация о проекте Lab1</h2>
            <ul>
                <li>Проект: Spring Boot приложение</li>
                <li>Версия Spring Boot: 3.5.5+</li>
                <li>Java версия: 17+</li>
                <li>Время запуска: %s</li>
            </ul>
            """.formatted(LocalDateTime.now());
    }
}