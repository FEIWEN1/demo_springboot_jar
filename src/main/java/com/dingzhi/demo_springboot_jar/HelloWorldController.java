package com.dingzhi.demo_springboot_jar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author feiwen
 * @date 2023/11/16
 */
@RestController
@RequestMapping("helloWorld")
public class HelloWorldController {


    @GetMapping("sayHello")
    public String sayHello() {
        return "hello world";
    }
}
