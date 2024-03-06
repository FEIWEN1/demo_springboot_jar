package com.dingzhi.demo_springboot_jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DemoSpringbootJarApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootJarApplication.class, args);
    }

}
