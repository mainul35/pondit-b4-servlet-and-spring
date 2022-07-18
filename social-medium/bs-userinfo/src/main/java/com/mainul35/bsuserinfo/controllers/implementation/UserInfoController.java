package com.mainul35.bsuserinfo.controllers.implementation;

import com.mainul35.bsuserinfo.controllers.definition.IUserInfoController;
import com.mainul35.bsuserinfo.controllers.dtos.request.Filter;
import com.mainul35.bsuserinfo.controllers.dtos.request.UserInfoRequest;
import com.mainul35.bsuserinfo.controllers.dtos.response.UserInfoResponse;
import com.mainul35.bsuserinfo.entity.UserEntity;
import com.mainul35.bsuserinfo.services.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public record UserInfoController(UserInfoService userInfoService) implements IUserInfoController {

    @Override
    public ResponseEntity<List<UserInfoResponse>> getUsers(Integer pageIxd, Integer itemsPerPage) {
        var userEntityList = userInfoService.getUsers(pageIxd, itemsPerPage);
        return ResponseEntity.ok(convertUserEntityListToUserInfoResponseList(userEntityList));
    }

    private List<UserInfoResponse> convertUserEntityListToUserInfoResponseList(List<UserEntity> userEntityList) {
        var userInfoResponses = new ArrayList<UserInfoResponse>();
        userEntityList.forEach(userEntity -> {
            UserInfoResponse response = new UserInfoResponse();
            BeanUtils.copyProperties(userEntity, response);
            userInfoResponses.add(response);
        });
        return userInfoResponses;
    }

    @Override
    public ResponseEntity<String> create(UserInfoRequest userInfoRequest) {
        userInfoService.create(userInfoRequest);
        return ResponseEntity.ok("Successfully created user");
    }

    @Override
    public ResponseEntity<List<UserInfoResponse>> search(Filter filter) {
        List<UserEntity> userEntityList = userInfoService.searchUser(filter);
        return ResponseEntity.ok(convertUserEntityListToUserInfoResponseList(userEntityList));
    }
}
