package com.mainul35.bsuserinfo.services.definition;

import com.mainul35.bsuserinfo.config.rabbitmq.RabbitMQConfig;
import com.mainul35.bsuserinfo.controllers.dtos.request.UserInfoRequest;
import com.mainul35.bsuserinfo.entity.UserEntity;
import com.mainul35.bsuserinfo.exceptions.NoContentException;
import com.mainul35.bsuserinfo.repositories.UserConnectionRepository;
import com.mainul35.bsuserinfo.repositories.UserInfoRepository;
import com.mainul35.bsuserinfo.services.impl.UserInfoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
class UserInfoServiceTest {

    private UserInfoService userInfoService;

    @Mock
    private UserInfoRepository userInfoRepository;

    @Mock
    private UserConnectionRepository userConnectionRepository;

    @Mock
    private AmqpTemplate amqpTemplate;

    UserInfoRequest request;
    UserEntity savedUser;

    @BeforeEach
    void setUp() {
        userInfoService = new UserInfoServiceImpl(userInfoRepository, userConnectionRepository, amqpTemplate);
        Assertions.assertNotNull(userInfoService);
        Assertions.assertNotNull(userInfoRepository);

        request = new UserInfoRequest();
        savedUser = new UserEntity();

        request.setId(UUID.randomUUID().toString());
        request.setEmail("mainuls18@gmail.com");
        request.setFirstName("Mainul");
        request.setSurname("Hasan");
        request.setUsername("mainul35");

        BeanUtils.copyProperties(request, savedUser);
    }

    @Test
    void getUsers() {
    }

    @Test
    void create() {
        Mockito.when(userInfoRepository.findByUsername(savedUser.getUsername())).thenReturn(Optional.empty());
        Mockito.when(userInfoRepository.save(Mockito.any())).thenReturn(savedUser, "mocking userInfoRepository.save(...) call");
        userInfoService.create(request);
        Assertions.assertNotNull(savedUser);
        Assertions.assertEquals("mainul35", savedUser.getUsername());
    }

    @Test
    void createUserConnections() {
    }

    @Test
    void searchUser() {
    }

    @Test
    void getUserById() {
    }
}