package com.mainul35.bsuserinfo.services;

import com.mainul35.bsuserinfo.entity.ConnectionStatus;
import com.mainul35.bsuserinfo.entity.UserConnection;
import com.mainul35.bsuserinfo.entity.UserConnectionId;
import com.mainul35.bsuserinfo.entity.UserEntity;
import com.mainul35.bsuserinfo.exceptions.NoContentException;
import com.mainul35.bsuserinfo.repositories.UserConnectionRepository;
import com.mainul35.bsuserinfo.repositories.UserInfoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public record UserConnectionService(UserInfoRepository userInfoRepository,
                                    UserConnectionRepository connectionRepository) {

    public void addConnection(String userId, String connectionId) {
        var userConnection = new UserConnection();
        userConnection.setUserConnectionId(getUserConnectionId(userId, connectionId));
        userConnection.setConnectionStatus(ConnectionStatus.REQUESTED);
        connectionRepository.save(userConnection);
    }

    private UserConnectionId getUserConnectionId(String userId, String connectionId) {
        var user = userInfoRepository.findById(userId)
                .orElseThrow(() -> new NoContentException("No user found with this userId"));
        var connection = userInfoRepository.findById(connectionId)
                .orElseThrow(() -> new NoContentException("No user found to connect"));
        return new UserConnectionId(user, connection);
    }

    public void acceptConnection(String userId, String connectionId) {
        var userConnection = connectionRepository.findByUserConnectionId(getUserConnectionId(userId, connectionId))
                .orElse(connectionRepository.findByUserConnectionId(getUserConnectionId(connectionId, userId)).orElse(null));
        if (Objects.isNull(userConnection)) {
            throw new NoContentException("No such connection request found");
        }
        userConnection.setConnectionStatus(ConnectionStatus.ACCEPTED);
        connectionRepository.save(userConnection);
    }

    public void rejectConnection(String userId, String connectionId) {
        var userConnection = connectionRepository.findByUserConnectionId(getUserConnectionId(userId, connectionId))
                .orElse(connectionRepository.findByUserConnectionId(getUserConnectionId(connectionId, userId)).orElse(null));
        if (Objects.isNull(userConnection)) {
            throw new NoContentException("No such connection request found");
        }
        userConnection.setConnectionStatus(ConnectionStatus.REJECTED);
        connectionRepository.save(userConnection);
    }

    public void blockConnection(String userId, String connectionId) {
        var userConnection = connectionRepository.findByUserConnectionId(getUserConnectionId(userId, connectionId))
                .orElse(connectionRepository.findByUserConnectionId(getUserConnectionId(connectionId, userId)).orElse(null));
        if (Objects.isNull(userConnection)) {
            throw new NoContentException("No such connection request found");
        }
        userConnection.setConnectionStatus(ConnectionStatus.BLOCKED);
        connectionRepository.save(userConnection);
    }

    public void unblockConnection(String userId, String connectionId) {
        var userConnection = connectionRepository.findByUserConnectionId(getUserConnectionId(userId, connectionId))
                .orElse(connectionRepository.findByUserConnectionId(getUserConnectionId(connectionId, userId)).orElse(null));
        if (Objects.isNull(userConnection)) {
            throw new NoContentException("No such connection request found");
        }
        userConnection.setConnectionStatus(ConnectionStatus.UNBLOCKED);
        connectionRepository.save(userConnection);
    }

    public List<UserEntity> getAllConnectionRequests(String userId, Integer pageIxd, Integer itemsPerPage) {
        var user = userInfoRepository.findById(userId)
                .orElseThrow(() -> new NoContentException("No user found with this user Id"));
        var list = connectionRepository
                .findAllByUserConnectionId_UserAndConnectionStatus(user, ConnectionStatus.REQUESTED, sortAndPaginate(pageIxd, itemsPerPage));
        return populatedUserEntitiesFromConnectionList(list);
    }

    public List<UserEntity> getAllBlockedConnections(String userId, Integer pageIxd, Integer itemsPerPage) {
        var user = userInfoRepository.findById(userId);
        user.orElseThrow(() -> new NoContentException("No user found with this user Id"));
        var list = connectionRepository
                .findAllByUserConnectionId_UserAndConnectionStatus(user.get(), ConnectionStatus.BLOCKED, sortAndPaginate(pageIxd, itemsPerPage));
        return populatedUserEntitiesFromConnectionList(list);
    }

    public List<UserEntity> getAllAcceptedConnections(String userId, Integer pageIxd, Integer itemsPerPage) {
        var user = userInfoRepository.findById(userId)
                .orElseThrow(() -> new NoContentException("No user found with this user Id"));
        var list = connectionRepository
                .findAllByUserConnectionId_UserAndConnectionStatus(user, ConnectionStatus.ACCEPTED, sortAndPaginate(pageIxd, itemsPerPage));
        return populatedUserEntitiesFromConnectionList(list);
    }

    private List<UserEntity> populatedUserEntitiesFromConnectionList(List<UserConnection> list) {
        List<UserEntity> userEntities = new ArrayList<>();
        list.forEach(userConnection -> {
            var connection = userInfoRepository.findById(userConnection.getUserConnectionId().getConnection().getId());
            connection.ifPresent(userEntities::add);
        });
        return userEntities;
    }
    private PageRequest sortAndPaginate(Integer pageIxd, Integer itemsPerPage) {
        return PageRequest.of(pageIxd - 1, itemsPerPage);
    }
}

/**
 * verbose Code
 * */

/*
@Service
public class UserConnectionService {

    private final UserInfoRepository userInfoRepository;
    private final UserConnectionRepository connectionRepository;

    public UserConnectionService(UserInfoRepository userInfoRepository, UserConnectionRepository connectionRepository) {
        this.userInfoRepository = userInfoRepository;
        this.connectionRepository = connectionRepository;
    }

    public void addConnection(String userId, String connectionId) {
        var userConnection = new UserConnection();
        UserConnectionId userConnectionId = getUserConnectionId(userId, connectionId);
        userConnection.setUserConnectionId(userConnectionId);
        userConnection.setConnectionStatus(ConnectionStatus.REQUESTED);
        connectionRepository.save(userConnection);
    }

    private UserConnectionId getUserConnectionId(String userId, String connectionId) {
        var userConnectionId = new UserConnectionId();
        var user = userInfoRepository.findById(userId)
                .orElseThrow(() -> new NoContentException("No user found with this userId"));
        var connection = userInfoRepository.findById(connectionId)
                .orElseThrow(() -> new NoContentException("No user found to connect"));
        userConnectionId.setUser(user);
        userConnectionId.setConnection(connection);
        return userConnectionId;
    }

    public void acceptConnection(String userId, String connectionId) {
        var userConnectionId = getUserConnectionId(userId, connectionId);
        var userConnection = connectionRepository.findByUserConnectionId(userConnectionId)
                .orElse(connectionRepository.findByUserConnectionId(getUserConnectionId(connectionId, userId))
                        .orElse(null));
        if (Objects.isNull(userConnection)) {
            throw new NoContentException("No such connection request found");
        }
        userConnection.setConnectionStatus(ConnectionStatus.ACCEPTED);
        connectionRepository.save(userConnection);
    }

    public void rejectConnection(String userId, String connectionId) {
        var userConnectionId = getUserConnectionId(userId, connectionId);
        var userConnection = connectionRepository.findByUserConnectionId(userConnectionId)
                .orElse(connectionRepository.findByUserConnectionId(getUserConnectionId(connectionId, userId)).orElse(null));
        if (Objects.isNull(userConnection)) {
            throw new NoContentException("No such connection request found");
        }
        userConnection.setConnectionStatus(ConnectionStatus.REJECTED);
        connectionRepository.save(userConnection);
    }

    public void blockConnection(String userId, String connectionId) {
        var userConnectionId = getUserConnectionId(userId, connectionId);
        var userConnection = connectionRepository.findByUserConnectionId(userConnectionId)
                .orElse(connectionRepository.findByUserConnectionId(getUserConnectionId(connectionId, userId)).orElse(null));
        if (Objects.isNull(userConnection)) {
            throw new NoContentException("No such connection request found");
        }
        userConnection.setConnectionStatus(ConnectionStatus.BLOCKED);
        connectionRepository.save(userConnection);
    }

    public void unblockConnection(String userId, String connectionId) {
        var userConnectionId = getUserConnectionId(userId, connectionId);
        var userConnection = connectionRepository.findByUserConnectionId(userConnectionId)
                .orElse(connectionRepository.findByUserConnectionId(getUserConnectionId(connectionId, userId)).orElse(null));
        if (Objects.isNull(userConnection)) {
            throw new NoContentException("No such connection request found");
        }
        userConnection.setConnectionStatus(ConnectionStatus.UNBLOCKED);
        connectionRepository.save(userConnection);
    }

    public List<UserEntity> getAllConnectionRequests(String userId, Integer pageIxd, Integer itemsPerPage) {
        var user = userInfoRepository.findById(userId).orElseThrow(() -> new NoContentException("No user found with this user Id"));
        var list = connectionRepository.findAllByUserConnectionId_UserAndAndConnectionStatus_Requested(user, PageRequest.of(pageIxd - 1, itemsPerPage, Sort.by(Sort.Order.asc("username"))));
        List<UserEntity> userEntities = new ArrayList<>();
        list.forEach(userConnection -> {
            var connection = userInfoRepository.findById(userConnection.getUserConnectionId().getConnection().getId());
            connection.ifPresent(userEntities::add);
        });
        return userEntities;
    }

    public List<UserEntity> getAllBlockedConnections(String userId, Integer pageIxd, Integer itemsPerPage) {
        var user = userInfoRepository.findById(userId);
        user.orElseThrow(() -> new NoContentException("No user found with this user Id"));
        var pagable = PageRequest.of(pageIxd - 1, itemsPerPage, Sort.by(Sort.Order.asc("username")));
        var list = connectionRepository.findAllByUserConnectionId_UserAndAndConnectionStatus_Blocked(user.get(), pagable);
        List<UserEntity> userEntities = new ArrayList<>();
        list.forEach(userConnection -> {
            var connection = userInfoRepository.findById(userConnection.getUserConnectionId().getConnection().getId());
            connection.ifPresent(userEntities::add);
        });
        return userEntities;
    }
}*/
