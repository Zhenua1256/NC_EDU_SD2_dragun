package com.netcracker.dragun.controller;

import com.netcracker.dragun.dto.Converter;
import com.netcracker.dragun.dto.UserDto;
import com.netcracker.dragun.entity.Company;
import com.netcracker.dragun.entity.DataUser;
import com.netcracker.dragun.entity.User;
import com.netcracker.dragun.repository.CompanyRepository;
import com.netcracker.dragun.repository.DataUserRepository;
import com.netcracker.dragun.repository.UserRepository;
import com.netcracker.dragun.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    @GetMapping
    public Object getAll(Long id) {
/*
        return userService.getAll();

*/

        return userRepository.findUserByDataUser_Id(id);
    }

    @GetMapping("/login/{login}")
    private UserDto get(@PathVariable String login) {
        User user = userRepository.findUserByDataUser_Login(login);
        if (user != null) {
            UserDto userDto = Converter.toDto(user);
            return userDto;
        } else {
            Company company = companyRepository.findCompanyByDataUser_Login(login);
            UserDto userDto = Converter.CompanytoUserDto(company);
            return userDto;
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        return userService.save(Converter.fromDto(userDto));
    }

   /* @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        User user = userService.save(Converter.fromDto(userDto));
        return user;
    }*/
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public User get(@PathVariable(name = "id") Long id) {
        return userService.get(id);
    }
}
