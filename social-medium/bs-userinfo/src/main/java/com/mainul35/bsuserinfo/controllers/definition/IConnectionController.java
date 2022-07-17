package com.mainul35.bsuserinfo.controllers.definition;

import com.mainul35.bsuserinfo.controllers.dtos.response.UserInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users/{username}/connections")
public interface IConnectionController {

    @PostMapping("/add/{connectionId}")
    ResponseEntity<?> addConnection(@PathVariable("username") String username, @PathVariable("connectionId") String connectionId);

    @GetMapping
    ResponseEntity<List<UserInfoResponse>> getConnectedUsers(@PathVariable(name = "username", required = false) String username, @RequestParam("pageIdx") Integer pageIxd, @RequestParam("itemsPerPage") Integer itemsPerPage);
}
