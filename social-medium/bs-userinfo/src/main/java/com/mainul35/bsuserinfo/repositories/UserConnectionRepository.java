package com.mainul35.bsuserinfo.repositories;

import com.mainul35.bsuserinfo.entity.ConnectionStatus;
import com.mainul35.bsuserinfo.entity.UserConnection;
import com.mainul35.bsuserinfo.entity.UserConnectionId;
import com.mainul35.bsuserinfo.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserConnectionRepository extends PagingAndSortingRepository<UserConnection, UserConnectionId> {
    Optional<UserConnection> findByUserConnectionId(UserConnectionId userConnectionId);
    Stream<UserConnection> findByUserConnectionId_User(UserEntity user);
    Stream<UserConnection> findByUserConnectionId_Connection(UserEntity user);
    Stream<UserConnection> findAllByUserConnectionId_UserAndConnectionStatus(UserEntity user, ConnectionStatus status);
    Stream<UserConnection> findAllByUserConnectionId_ConnectionAndConnectionStatus(UserEntity user, ConnectionStatus status);
}
