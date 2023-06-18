package com.khanduja.techwonders.controller.security;

import com.khanduja.techwonders.exceptionhandling.config.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/")
public class AdminController {

    @GetMapping
    public ResponseEntity<String> getAdminAccess() {
        return new ResponseEntity<>("Admin Logged In", HttpStatus.OK);
    }

    @GetMapping("exception")
    public ResponseEntity<String> getCustomException() {
        throw new CustomException("Custom Exception has been thrown", HttpStatus.BAD_REQUEST);
    }
}
