package com.netcraker.dragun.converter;

import com.netcraker.dragun.model.DataUser;
import com.netcraker.dragun.model.User;

public class UserConverter {
    public static User toUser(UserDto userDto) {
        User user = User.builder()
                .login(userDto.getLogin())
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .role(userDto.getRole())
                .build();
        return user;
    }
    public static UserDto toDto(User user, DataUser dataUser) {

        return UserDto.builder()
                .login(dataUser.getLogin())
                .password(dataUser.getPassword())
                .role(dataUser.getRole())
                .lastName(user.getLastName())
                .name(user.getName())
                .build();
    }

}
