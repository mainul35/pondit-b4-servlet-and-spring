package com.mainul35.bsuserinfo.services;

import com.mainul35.bsuserinfo.controllers.dtos.request.Filter;
import com.mainul35.bsuserinfo.controllers.dtos.request.UserInfoRequest;
import com.mainul35.bsuserinfo.entity.UserEntity;
import com.mainul35.bsuserinfo.enums.Field;
import com.mainul35.bsuserinfo.repositories.UserInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @PersistenceContext
    EntityManager em;

    public List<UserEntity> getUsers(Integer pageIxd, Integer itemsPerPage) {
        Pageable pagable = PageRequest.of(pageIxd - 1, itemsPerPage, Sort.by(Sort.Order.asc("username")));
        return userInfoRepository.findAll(pagable).toList();
    }

    public void create(UserInfoRequest userInfoRequest) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userInfoRequest, userEntity);
        userEntity.setId(UUID.randomUUID().toString());
        userInfoRepository.save(userEntity);
    }

    public List<UserEntity> searchUser(Filter filter) {
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);
        cq.select(root);
        if (filter.getField().equals(Field.username.getValue())) {
            cq.where(cb.equal(root.get(Field.username.getValue()), filter.getValue()));
        }
        else if (filter.getField().equals(Field.email.getValue())) {
            cq.where(cb.equal(root.get(Field.email.getValue()), filter.getValue()));
        } else {
            throw new RuntimeException("Search criteria doesn't match");
        }
        var query = em.createQuery(cq);
        return query.getResultList();
    }
}
