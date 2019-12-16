package com.netcracker.dragun.dto;

import com.netcracker.dragun.entity.Company;
import com.netcracker.dragun.entity.DataUser;
import com.netcracker.dragun.entity.User;

public class Converter {

    public static User fromDto(UserDto userDto) {

        DataUser dataUser = DataUser.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .build();

        User user = User.builder()
                .dataUser(dataUser)
                .role(userDto.getRole())
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .build();
        return user;
    }
    public static UserDto toDto(User user) {

        return UserDto.builder()
                .id(user.getId())
                .login(user.getDataUser().getLogin())
                .password(user.getDataUser().getPassword())
                .role(user.getRole())
                .lastName(user.getLastName())
                .name(user.getName())
                .build();
    }
    public static UserDto CompanytoUserDto(Company company) {

        return UserDto.builder()
                .id(company.getId())
                .login(company.getDataUser().getLogin())
                .password(company.getDataUser().getPassword())
                .role(company.getRole())
                .build();
    }
    public static Company fromDto(CompanyDto companyDto){
        DataUser dataUser = DataUser.builder()
                .login(companyDto.getLogin())
                .password(companyDto.getPassword())
                .build();

        Company company = Company.builder()
                .dataUser(dataUser)
                .role(companyDto.getRole())
                .contactNumber(companyDto.getContactNumber())
                .directorName(companyDto.getDirectorName())
                .legalAddres(companyDto.getLegalAddress())
                .name(companyDto.getName()).build();
        return company;
    }
    public static CompanyDto toDto(Company company, DataUser dataUser){
        return CompanyDto.builder()
                .login(dataUser.getLogin())
                .password(dataUser.getPassword())
                .role(company.getRole())
                .name(company.getName())
                .contactNumber(company.getContactNumber())
                .directorName(company.getDirectorName())
                .legalAddress(company.getLegalAddres())
                .build();
    }
}