package com.netcracker.dragun.dto;

import com.netcracker.dragun.entity.Company;
import com.netcracker.dragun.entity.DataUser;
import com.netcracker.dragun.entity.User;

public class Converter {

    public static User fromDto(UserDto userDto) {

        DataUser dataUser = DataUser.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .build();

        User user = User.builder()
                .dataUser(dataUser)
                .email(userDto.getEmail())
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .build();
        return user;
    }
    public static UserDto toDto(User user, DataUser dataUser) {

        return UserDto.builder()
                .login(dataUser.getLogin())
                .password(dataUser.getPassword())
                .role(dataUser.getRole())
                .email(user.getEmail())
                .lastName(user.getLastName())
                .name(user.getName())
                .build();


    }
    public static Company fromDto(CompanyDto companyDto){
        DataUser dataUser = DataUser.builder()
                .login(companyDto.getLogin())
                .password(companyDto.getPassword())
                .role(companyDto.getRole())
                .build();

        Company company = Company.builder()
                .dataUser(dataUser)
                .contactNumber(companyDto.getContactNumber())
                .directorName(companyDto.getDirectorName())
                .legalAddres(companyDto.getLegalAddres())
                .name(companyDto.getName()).build();
        return company;
    }
    public static CompanyDto toDto(Company company, DataUser dataUser){
        return CompanyDto.builder()
                .login(dataUser.getLogin())
                .password(dataUser.getPassword())
                .role(dataUser.getRole())
                .name(company.getName())
                .contactNumber(company.getContactNumber())
                .directorName(company.getDirectorName())
                .legalAddres(company.getLegalAddres())
                .build();
    }
}