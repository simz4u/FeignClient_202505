package com.example.server1.controller;

import com.example.server1.client.Server2EurekaClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/eureka")
public class EurekaCallController {

    private final Server2EurekaClient server2Client;
    @GetMapping("/call-server2")
    public String callServer2() {
        log.info("Eureka Call Server2!!");
        return server2Client.getHello();
    }
}
