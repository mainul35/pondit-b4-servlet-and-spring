package com.example.springbootdemo.models;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class User {
    @NotBlank(message = "Username is mandatory")
    private String username;
    @Email
    private String email;
    private String name;
    private String id;
}
