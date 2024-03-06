package com.dingzhi.demo_springboot_jar.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Timer;

/**
 * @author feiwen
 * @date 2024/3/6
 */
@Component
public class Task1 {

    @Scheduled(cron = "*/3 * * * * ?")
    public void sayHello(){
        System.out.println("hello");


    }
}
