package com.mainul35.bsuserinfo.controllers.definition;

import com.mainul35.bsuserinfo.controllers.dtos.request.Filter;
import com.mainul35.bsuserinfo.controllers.dtos.request.UserInfoRequest;
import com.mainul35.bsuserinfo.controllers.dtos.response.UserConnectionInfoResponse;
import com.mainul35.bsuserinfo.controllers.dtos.response.UserInfoResponse;
import com.mainul35.bsuserinfo.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;

@RequestMapping("/users")
@CrossOrigin("${cross.origin}")
public interface IUserInfoController {

    @GetMapping
    ResponseEntity<List<UserInfoResponse>> getUsers(@RequestParam("pageIdx") Integer pageIxd, @RequestParam("itemsPerPage") Integer itemsPerPage);

    @PostMapping("/create")
    ResponseEntity<String> create(@RequestBody UserInfoRequest userInfoRequest);

    @PostMapping("/search")
    ResponseEntity<List<UserInfoResponse>> search(@Valid @RequestBody Filter Filter);

    @GetMapping("/{id}/profile")
    ResponseEntity<UserInfoResponse> getUserProfileById(@PathVariable("id") String id);

    @GetMapping("/{id}/non-connected-users")
    ResponseEntity<List<UserConnectionInfoResponse>> getNonConnectedUsers(@PathVariable("id") String id, @RequestParam("pageIdx") Integer pageIxd, @RequestParam(value = "itemsPerPage") Integer itemsPerPage);
}
