//package com.mainul35.bsuserinfo.initialize;
//
//import com.mainul35.bsuserinfo.repositories.UserInfoRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//
//import javax.validation.constraints.AssertTrue;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest
//class InitializeDataTest {
//
//    private InitializeData initializeData;
//    @Autowired
//    private UserInfoRepository userInfoRepository;
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @BeforeEach
//    void setUp() {
//        initializeData = applicationContext.getBean(InitializeData.class);
//        Assertions.assertNotNull(initializeData);
//    }
//
//    @Test
//    @DisplayName("Test for initializing db")
//    void initialize() {
//        initializeData.initialize();
//        var usersCount = userInfoRepository.count();
//        Assertions.assertTrue(usersCount > 0, "User records inserted successfully");
//    }
//}