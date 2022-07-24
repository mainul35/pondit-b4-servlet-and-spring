package com.mainul35.bsuserinfo.controllers.dtos.request;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserInfoRequest {
    private String id;
    private String firstName;
    private String surname;
    private String email;
    private String username;
    private String profileImagePath;
}
