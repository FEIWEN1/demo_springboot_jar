package com.dingzhi.demo_springboot_jar.stateMachine.setcodes;

/**
 * @author feiwen
 * @date 2024/3/5
 */
public class AlarmEvent implements Event{
    @Override
    public String execute() {
        return "alarm";
    }
}
