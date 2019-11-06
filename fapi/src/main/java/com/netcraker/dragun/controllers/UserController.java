package com.netcraker.dragun.controllers;

import com.netcraker.dragun.model.User;
import com.netcraker.dragun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User get(@PathVariable(name = "id") Long id) {
        return userService.get(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public void create(@RequestBody User user,
                        @PathVariable(name = "id") Long id) {
        userService.update(user, id);
    }
    @DeleteMapping("/{id}")
    public void create(@PathVariable(name = "id") Long id) {
        userService.delete(id);
    }
}
