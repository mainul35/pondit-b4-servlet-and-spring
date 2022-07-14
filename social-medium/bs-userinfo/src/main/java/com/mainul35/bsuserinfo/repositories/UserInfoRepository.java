package com.mainul35.bsuserinfo.repositories;

import com.mainul35.bsuserinfo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends PagingAndSortingRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findById(String s);

    Optional<UserEntity> findByUsername(String username);
}
