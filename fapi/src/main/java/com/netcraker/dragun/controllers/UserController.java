package com.netcraker.dragun.controllers;

import com.netcraker.dragun.model.User;
import com.netcraker.dragun.service.CompanyService;
import com.netcraker.dragun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final CompanyService companyService;

    @Autowired
    public UserController(UserService userService, CompanyService companyService) {
        this.companyService = companyService;
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
    public ResponseEntity createDataUser(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    //    @PreAuthorize("isAuthenticated()")
    @GetMapping("/current")
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user;
        user =  userService.getUserByLogin(((org.springframework.security.core.userdetails.User) authentication
                .getPrincipal()).getUsername());
        return user;
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
