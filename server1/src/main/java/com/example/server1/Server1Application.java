package com.example.server1;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.Arrays;

@Slf4j
@SpringBootApplication
@MapperScan("com.example.server1.mapper")
@EnableFeignClients(basePackages = "com.example.server1.client")
@EnableDiscoveryClient
public class Server1Application {
    public static void main(String[] args) throws IOException {

        SpringApplication.run(Server1Application.class, args);

        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mapper/**/*.xml");

        Arrays.stream(resources).forEach(r -> log.info("Mapper File[{}] loaded...", r.getFilename()));
    }
}
