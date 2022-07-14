package com.mainul35.bsuserinfo.controllers.implementation;

import com.mainul35.bsuserinfo.controllers.definition.IControllerUserInfo;
import com.mainul35.bsuserinfo.controllers.dtos.request.UserInfoRequest;
import com.mainul35.bsuserinfo.controllers.dtos.response.UserInfoResponse;
import com.mainul35.bsuserinfo.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController implements IControllerUserInfo {

    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Override
    public void save(UserInfoRequest userInfoRequest) {

    }

    @Override
    public List<UserInfoResponse> getConnectedUsers(String username, Integer pageIxd, Integer itemsPerPage) {
        return userInfoService.getConnectedUsers(username, pageIxd, itemsPerPage);
    }

//    @Override
//    public UserInfoResponse findByUsername(String username) {
//        return null;
//    }

    @Override
    public UserInfoResponse findByEmail(String email) {
        return userInfoService.findByEmail(email);
    }
}
