package com.mainul35.bsuserinfo.controllers.definition;

import com.mainul35.bsuserinfo.controllers.dtos.response.UserInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users/{userId}/connections")
public interface IConnectionController {

    @PostMapping("/request/{connectionId}")
    ResponseEntity<?> requestConnection(@PathVariable("userId") String userId, @PathVariable("connectionId") String connectionId);

    @PutMapping("/accept/{connectionId}")
    ResponseEntity<?> acceptConnection(@PathVariable("userId") String userId, @PathVariable("connectionId") String connectionId);

    @PutMapping("/reject/{connectionId}")
    ResponseEntity<?> rejectConnection(@PathVariable("userId") String userId, @PathVariable("connectionId") String connectionId);

    @PutMapping("/block/{connectionId}")
    ResponseEntity<?> blockConnection(@PathVariable("userId") String userId, @PathVariable("connectionId") String connectionId);

    @PutMapping("/unblock/{connectionId}")
    ResponseEntity<?> unblockConnection(@PathVariable("userId") String userId, @PathVariable("connectionId") String connectionId);

    @GetMapping("/requests")
    ResponseEntity<List<UserInfoResponse>> getConnectionRequests(@PathVariable(name = "userId", required = false) String userId, @RequestParam("pageIdx") Integer pageIxd, @RequestParam("itemsPerPage") Integer itemsPerPage);

    @GetMapping("/blocked")
    ResponseEntity<List<UserInfoResponse>> getBlockedConnections(@PathVariable(name = "userId", required = false) String userId, @RequestParam("pageIdx") Integer pageIxd, @RequestParam("itemsPerPage") Integer itemsPerPage);

    @GetMapping
    ResponseEntity<List<UserInfoResponse>> getConnectedUsers(@PathVariable(name = "userId", required = false) String userId, @RequestParam("pageIdx") Integer pageIxd, @RequestParam("itemsPerPage") Integer itemsPerPage);
}
