package com.mainul35.bsuserinfo.controllers.implementation;

import com.mainul35.bsuserinfo.controllers.definition.IConnectionController;
import com.mainul35.bsuserinfo.controllers.dtos.response.UserInfoResponse;
import com.mainul35.bsuserinfo.entity.UserEntity;
import com.mainul35.bsuserinfo.services.UserConnectionService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public record UserConnectionController(UserConnectionService userConnectionService) implements IConnectionController {

    @Override
    public ResponseEntity<?> requestConnection(String userId, String connectionId) {
        userConnectionService.addConnection(userId, connectionId);
        return ResponseEntity.ok("Connection request sent");
    }

    @Override
    public ResponseEntity<?> acceptConnection(String userId, String connectionId) {
        userConnectionService.acceptConnection(userId, connectionId);
        return ResponseEntity.ok("Connection request has been accepted");
    }

    @Override
    public ResponseEntity<?> rejectConnection(String userId, String connectionId) {
        userConnectionService.rejectConnection(userId, connectionId);
        return ResponseEntity.ok("Connection request has been rejected");
    }

    @Override
    public ResponseEntity<?> blockConnection(String userId, String connectionId) {
        userConnectionService.blockConnection(userId, connectionId);
        return ResponseEntity.ok("User blocked successfully");
    }

    @Override
    public ResponseEntity<?> unblockConnection(String userId, String connectionId) {
        userConnectionService.unblockConnection(userId, connectionId);
        return ResponseEntity.ok("User unblocked successfully");
    }

    @Override
    public ResponseEntity<List<UserInfoResponse>> getConnectionRequests(String userId, Integer pageIxd, Integer itemsPerPage) {
        var list = userConnectionService.getAllConnectionRequests(userId, pageIxd, itemsPerPage);
        return ResponseEntity.ok(this.convertUserEntityListToUserInfoResponseList(list));
    }

    @Override
    public ResponseEntity<List<UserInfoResponse>> getBlockedConnections(String userId, Integer pageIxd, Integer itemsPerPage) {
        var list = userConnectionService.getAllBlockedConnections(userId, pageIxd, itemsPerPage);
        return ResponseEntity.ok(this.convertUserEntityListToUserInfoResponseList(list));
    }

    @Override
    public ResponseEntity<List<UserInfoResponse>> getConnectedUsers(String userId, Integer pageIxd, Integer itemsPerPage) {
        var list = userConnectionService.getAllAcceptedConnections(userId, pageIxd, itemsPerPage);
        return ResponseEntity.ok(this.convertUserEntityListToUserInfoResponseList(list));
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
}
