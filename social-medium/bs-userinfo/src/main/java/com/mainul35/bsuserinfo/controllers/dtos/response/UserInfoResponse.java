package com.mainul35.bsuserinfo.controllers.dtos.response;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserInfoResponse {
    private String id;
    private String firstName;
    private String surname;
    private String email;
    private String username;
    private String profileImage;
}
