package com.mainul35.bsuserinfo.services.definition;

import com.mainul35.bsuserinfo.controllers.dtos.response.UserConnectionInfoResponse;
import com.mainul35.bsuserinfo.entity.UserConnection;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserConnectionService {
    @Transactional
    UserConnection addConnection(String userId, String connectionId);

    UserConnectionInfoResponse acceptConnection(String userId, String connectionId);

    UserConnectionInfoResponse rejectConnection(String userId, String connectionId);

    UserConnectionInfoResponse blockConnection(String userId, String connectionId);

    UserConnectionInfoResponse unblockConnection(String userId, String connectionId);

    List<UserConnectionInfoResponse> getAllConnectionRequests(String userId, Integer pageIxd, Integer itemsPerPage);

    List<UserConnectionInfoResponse> getAllBlockedConnections(String userId, Integer pageIxd, Integer itemsPerPage);

    List<UserConnectionInfoResponse> getAllAcceptedConnections(String userId, Integer pageIxd, Integer itemsPerPage);

    @Transactional
    List<UserConnectionInfoResponse> getNonConnectedUsers(String id, Integer pageIxd, Integer itemsPerPage);
}
