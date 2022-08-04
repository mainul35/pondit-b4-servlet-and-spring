package com.mainul35.bsuserinfo.services.definition;

import com.mainul35.bsuserinfo.config.rabbitmq.RabbitMQConfig;
import com.mainul35.bsuserinfo.controllers.dtos.request.Filter;
import com.mainul35.bsuserinfo.controllers.dtos.request.UserInfoRequest;
import com.mainul35.bsuserinfo.controllers.dtos.response.UserInfoResponse;
import com.mainul35.bsuserinfo.entity.UserEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.List;

public interface UserInfoService {
    List<UserEntity> getUsers(Integer pageIxd, Integer itemsPerPage);

    void create(UserInfoRequest userInfoRequest);

    @RabbitListener(queues = RabbitMQConfig.RMQ_NAME)
    void createUserConnections(String userId);

    List<UserEntity> searchUser(Filter filter);

    UserInfoResponse getUserById(String id);
}
