package com.example.server1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.server1.client")
public class Server1Application {
    public static void main(String[] args) {
        SpringApplication.run(Server1Application.class, args);
    }
}
