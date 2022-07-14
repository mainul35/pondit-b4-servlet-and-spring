package com.mainul35.bsuserinfo.controllers.definition;

import com.mainul35.bsuserinfo.controllers.dtos.request.UserInfoRequest;
import com.mainul35.bsuserinfo.controllers.dtos.response.UserInfoResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping("/users")
public interface IControllerUserInfo {

    @PostMapping("/create")
    void save(UserInfoRequest userInfoRequest);

    @GetMapping("/connections/{username}")
    List<UserInfoResponse> getConnectedUsers(@PathVariable(name = "username", required = false) String username, @RequestParam("pageIdx") Integer pageIxd, @RequestParam("itemsPerPage") Integer itemsPerPage);

//    @GetMapping("/{username}")
//    UserInfoResponse findByUsername(@PathVariable("username") String username);

    @GetMapping("/{email}")
    UserInfoResponse findByEmail(@PathVariable("email") String email);
}
