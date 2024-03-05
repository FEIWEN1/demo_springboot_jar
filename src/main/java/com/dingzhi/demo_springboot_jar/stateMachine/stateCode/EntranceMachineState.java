package com.dingzhi.demo_springboot_jar.stateMachine.stateCode;



/**
 *  有多少个动作定义多少个方法 有多少个状态定义多少个实现类
 * @author feiwen
 * @date 2024/3/5
 */
public interface EntranceMachineState {
    String insertCoin(EntranceMachine entranceMachine);

    String pass(EntranceMachine entranceMachine);
}
