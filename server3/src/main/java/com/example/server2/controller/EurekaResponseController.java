package com.example.server2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaResponseController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Server3!";
    }
}
