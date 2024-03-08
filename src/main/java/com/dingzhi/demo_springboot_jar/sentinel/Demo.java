package com.dingzhi.demo_springboot_jar.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

/**
 * @author feiwen
 * @date 2024/3/8
 */
public class Demo {

    @SentinelResource(value = "demo",blockHandler = "handleBlock")
    public String demoTest(){
        return "";
    }
}
