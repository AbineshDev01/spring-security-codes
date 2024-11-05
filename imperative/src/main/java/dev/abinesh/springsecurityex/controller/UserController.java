package dev.abinesh.springsecurityex.controller;

import dev.abinesh.springsecurityex.entity.User;
import dev.abinesh.springsecurityex.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/login")
    public String login(@RequestBody User user) {
        return userService.verify(user);
    }
}
