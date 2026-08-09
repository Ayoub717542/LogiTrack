package org.example.logitrack.controller;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.service.serviceImpl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class userController {

    private final UserService userService;

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/count")
    public ResponseEntity<Long> countUsers(){
      return ResponseEntity.ok( userService.countUsers()) ;
    }

}
