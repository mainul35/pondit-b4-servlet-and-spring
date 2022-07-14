package com.mainul35.bsuserinfo.controllers.dtos.request;

import lombok.Data;

@Data
public class UserInfoRequest {
    private String id;
    private String name;
    private String email;
    private String username;
    private String profileImage;
}
