package com.netcracker.dragun.controller;
import com.netcracker.dragun.dto.Converter;
import com.netcracker.dragun.dto.UserDto;
import com.netcracker.dragun.entity.User;
import com.netcracker.dragun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = userService.save(Converter.fromDto(userDto));
        return userDto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserbyId(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping(value = "/{id}")
    public User get(@PathVariable(name = "id") Long id) {
        return userService.get(id);
    }
}
