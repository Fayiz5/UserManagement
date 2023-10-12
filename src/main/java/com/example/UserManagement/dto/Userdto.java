package com.example.UserManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Userdto {
    private int id;
    @NotEmpty
    private String name;
    @Email(message = "Email is not Valid")
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String about;
}
