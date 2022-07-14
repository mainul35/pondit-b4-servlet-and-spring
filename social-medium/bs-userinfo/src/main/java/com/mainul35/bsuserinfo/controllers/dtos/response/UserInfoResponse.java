package com.mainul35.bsuserinfo.controllers.dtos.response;

import lombok.Data;

@Data
public class UserInfoResponse {
    private String id;
    private String name;
    private String email;
    private String username;
    private String profileImage;
}
