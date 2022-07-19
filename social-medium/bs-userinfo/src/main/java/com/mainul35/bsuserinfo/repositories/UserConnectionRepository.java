package com.mainul35.bsuserinfo.repositories;

import com.mainul35.bsuserinfo.entity.ConnectionStatus;
import com.mainul35.bsuserinfo.entity.UserConnection;
import com.mainul35.bsuserinfo.entity.UserConnectionId;
import com.mainul35.bsuserinfo.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserConnectionRepository extends PagingAndSortingRepository<UserConnection, UserConnectionId> {
    Optional<UserConnection> findByUserConnectionId(UserConnectionId userConnectionId);

    List<UserConnection> findAllByUserConnectionId_UserAndConnectionStatus(UserEntity user, ConnectionStatus status, Pageable pageable);
}
