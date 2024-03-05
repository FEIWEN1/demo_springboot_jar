package com.dingzhi.demo_springboot_jar.stateMachine.enumCodes;

/**
 * @author feiwen
 * @date 2024/3/5
 */
public enum Action {
    PASS {
        @Override
        public String execute(EntraceMachine entranceMachine, EntranceMachineState state) {
            return state.pass(entranceMachine);
        }
    },
    INSERT_COIN {
        @Override
        public String execute(EntraceMachine entranceMachine, EntranceMachineState state) {
            return state.insertCoin(entranceMachine);
        }
    };

    public abstract String execute(EntraceMachine entranceMachine, EntranceMachineState state);
}
