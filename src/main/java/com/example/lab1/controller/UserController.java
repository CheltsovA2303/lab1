package com.example.lab1.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private List<String> users = new ArrayList<>();

    // Конструктор - инициализируем начальными данными
    public UserController() {
        users.add("Иван Иванов");
        users.add("Петр Петров");
        users.add("Мария Сидорова");
        users.add("Анна Ковалева");
        users.add("Сергей Смирнов");
    }

    // GET /api/users - получить всех пользователей
    @GetMapping
    public List<String> getAllUsers() {
        return users;
    }

    // GET /api/users/{id} - получить пользователя по ID
    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        if (id >= 0 && id < users.size()) {
            return "Пользователь #" + id + ": " + users.get(id);
        }
        return "Пользователь с ID " + id + " не найден";
    }

    // POST /api/users - добавить нового пользователя
    @PostMapping
    public String addUser(@RequestBody String userName) {
        users.add(userName);
        return "Пользователь добавлен: " + userName + ". Всего пользователей: " + users.size();
    }

    // DELETE /api/users/{id} - удалить пользователя по ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        if (id >= 0 && id < users.size()) {
            String removedUser = users.remove(id);
            return "Пользователь удален: " + removedUser + ". Осталось пользователей: " + users.size();
        }
        return "Пользователь с ID " + id + " не найден";
    }

    // GET /api/users/count - получить количество пользователей
    @GetMapping("/count")
    public String getUsersCount() {
        return "Всего пользователей в системе: " + users.size();
    }

    // GET /api/users/search - поиск пользователей по имени
    @GetMapping("/search")
    public List<String> searchUsers(@RequestParam String name) {
        List<String> result = new ArrayList<>();
        for (String user : users) {
            if (user.toLowerCase().contains(name.toLowerCase())) {
                result.add(user);
            }
        }
        return result;
    }
}