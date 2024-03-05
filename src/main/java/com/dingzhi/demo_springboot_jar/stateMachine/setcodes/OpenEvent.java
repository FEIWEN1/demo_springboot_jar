package com.dingzhi.demo_springboot_jar.stateMachine.setcodes;

/**
 * @author feiwen
 * @date 2024/3/5
 */
public class OpenEvent implements Event{
    @Override
    public String execute() {
        return "opened";
    }
}
