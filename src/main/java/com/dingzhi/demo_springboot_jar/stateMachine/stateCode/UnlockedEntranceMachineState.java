package com.dingzhi.demo_springboot_jar.stateMachine.stateCode;

/**
 * @author feiwen
 * @date 2024/3/5
 */
public class UnlockedEntranceMachineState implements EntranceMachineState{
    @Override
    public String insertCoin(EntranceMachine entranceMachine) {
        return entranceMachine.refund();
    }

    @Override
    public String pass(EntranceMachine entranceMachine) {
        return entranceMachine.close();
    }
}
