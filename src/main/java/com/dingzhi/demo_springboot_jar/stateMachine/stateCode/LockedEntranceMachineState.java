package com.dingzhi.demo_springboot_jar.stateMachine.stateCode;

/**
 * 每个状态下状态机 不同的动作执行不同的逻辑
 * @author feiwen
 * @date 2024/3/5
 */
public class LockedEntranceMachineState implements EntranceMachineState{
    @Override
    public String insertCoin(EntranceMachine entranceMachine) {
        return entranceMachine.open();
    }

    @Override
    public String pass(EntranceMachine entranceMachine) {
        return entranceMachine.alarm();
    }
}
