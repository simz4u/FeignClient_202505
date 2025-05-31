package com.example.server1.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "server2") // Eureka에 등록된 이름으로 호출
public interface Server2EurekaClient {
    @GetMapping("/hello")
    String getHello();

}
