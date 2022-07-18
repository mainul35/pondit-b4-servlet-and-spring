package com.mainul35.bsuserinfo.repositories;

import com.mainul35.bsuserinfo.controllers.dtos.request.Filter;
import com.mainul35.bsuserinfo.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends PagingAndSortingRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findById(String s);
}
