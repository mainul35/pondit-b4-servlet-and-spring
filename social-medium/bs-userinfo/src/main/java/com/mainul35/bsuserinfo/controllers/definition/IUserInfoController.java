package com.mainul35.bsuserinfo.controllers.definition;

import com.mainul35.bsuserinfo.controllers.dtos.request.Filter;
import com.mainul35.bsuserinfo.controllers.dtos.request.UserInfoRequest;
import com.mainul35.bsuserinfo.controllers.dtos.response.UserInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface IUserInfoController {

    @GetMapping
    ResponseEntity<List<UserInfoResponse>> getUsers(@RequestParam("pageIdx") Integer pageIxd, @RequestParam("itemsPerPage") Integer itemsPerPage);

    @PostMapping("/create")
    ResponseEntity<String> create(@RequestBody UserInfoRequest userInfoRequest);

    @PostMapping("/search")
    ResponseEntity<List<UserInfoResponse>> search(@RequestBody Filter Filter);
}
