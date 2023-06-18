package com.khanduja.techwonders.controller.security;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    @GetMapping
    public ResponseEntity<String> getUserAccess() {
        return new ResponseEntity<>("User Logged In", HttpStatus.OK);
    }
}
