package com.mainul35.bsuserinfo.initialize;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mainul35.bsuserinfo.controllers.dtos.request.UserInfoRequest;
import com.mainul35.bsuserinfo.repositories.UserInfoRepository;
import com.mainul35.bsuserinfo.services.impl.UserInfoServiceImpl;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Profile({"dev", "test"})
@Component
public class InitializeTestData implements InitializeData {

    private final UserInfoRepository userRepository;

    private final UserInfoServiceImpl userInfoService;

    private final ResourceLoader resourceLoader;

    public InitializeTestData(UserInfoRepository userRepository, UserInfoServiceImpl userInfoService, ResourceLoader resourceLoader) {
        this.userRepository = userRepository;
        this.userInfoService = userInfoService;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void initialize() {
        addUsers ();
    }

    private void addUsers() {

        if (userRepository.count() < 1) {
            try {
                List<UserInfoRequest> userModels = new ObjectMapper ()
                        .readValue (
                                resourceLoader.getResource ("classpath:users.json").getInputStream (),
                                new TypeReference<ArrayList<UserInfoRequest>> () {
                                }
                        );
                userModels.forEach (userInfoRequest -> {
                    userInfoRequest.setId(UUID.randomUUID().toString());
                    userInfoService.create(userInfoRequest);
                });
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
//        userRepository.deleteAll ();

    }
}
