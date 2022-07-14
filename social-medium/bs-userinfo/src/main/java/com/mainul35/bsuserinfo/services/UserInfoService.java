package com.mainul35.bsuserinfo.services;

import com.mainul35.bsuserinfo.controllers.dtos.response.UserInfoResponse;
import com.mainul35.bsuserinfo.entity.UserEntity;
import com.mainul35.bsuserinfo.repositories.UserInfoRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;


    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public UserInfoResponse findByEmail(String email) {
        var userEntityOptional = userInfoRepository.findByEmail(email);

        UserInfoResponse response = new UserInfoResponse();
        userEntityOptional.ifPresent(userEntity -> {
            BeanUtils.copyProperties(userEntity, response);
        });
        userEntityOptional.orElseThrow(() -> new NoSuchElementException("No user found with this email address"));
        return response;
    }

    public List<UserInfoResponse> getConnectedUsers(String username, Integer pageIxd, Integer itemsPerPage) {
        Iterable<UserEntity> userEntities = new ArrayList<>();
        if (username.isBlank()) {
            userEntities = userInfoRepository.findAll();
        } else {
            // TODO: later
//            userEntities = userInfoRepository.findConnectedUsers(username, getPage(pageIxd, itemsPerPage));
        }
        var userInfoResponseList = new ArrayList<UserInfoResponse>();
        userEntities.forEach(userEntity ->{
            var response = new UserInfoResponse();
            BeanUtils.copyProperties(userEntity, response);
            userInfoResponseList.add(response);
        });
        return userInfoResponseList;
    }

    public PageRequest getPage(int pageNumber, int resultPerPage) {
        return PageRequest.of(pageNumber - 1,  resultPerPage, Sort.Direction.DESC);
    }
//
//    private List<User> users = new ArrayList<>();
//
//    public UserService() {
//        var user = new User();
//        user.setEmail("info.efowe.com");
//        user.setName("Mainul");
//        user.setId("1");
//
//        var user2 = new User();
//        user2.setEmail("info.efowe.com");
//        user2.setName("Mainul");
//        user2.setId("2");
//        users.add(user);
//        users.add(user2);
//    }
//
//    public User getById(String id) {
//        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
//    }
//
//    public List<User> getAllUsers() {
//        System.out.println(users.hashCode());
//        var copyUsers = List.copyOf(users);
//        System.out.println(copyUsers.hashCode());
//        return copyUsers;
//    }
//
//    public void save(User user) {
//        var matchingUser = users.stream().filter(user1 -> user1.getEmail().equals(user.getEmail())).findAny();
//        matchingUser.ifPresent(user1 -> {throw new RuntimeException("User with this email already registered");});
//
//        this.users.add(user);
//    }
}
