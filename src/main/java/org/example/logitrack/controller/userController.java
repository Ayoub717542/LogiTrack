package org.example.logitrack.controller;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.service.serviceImpl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class userController {
    private final  UserService userService;


    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public ResponseEntity<Long> countUsers(){
      return ResponseEntity.ok( userService.countUsers()) ;
    }























//    @PreAuthorize("hasAnyRole('ADMIN')")
//    @PutMapping("/disableAccount/{id}")
//    public void disableAccount(@PathVariable int id){
//        userService.disableAccount(id);
//    }
}