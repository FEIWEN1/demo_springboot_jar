package com.dingzhi.demo_springboot_jar.stateMachine.enumCodes;

/**
 * 定义状态机状态枚举 每个枚举内部定义所有动作方法
 * @author feiwen
 * @date 2024/3/5
 */
public enum EntranceMachineState {
    LOCKED {
        @Override
        public String insertCoin(EntraceMachine entranceMachine) {
            entranceMachine.setState(UNLOCKED);
            return entranceMachine.open();
        }

        @Override
        public String pass(EntraceMachine entranceMachine) {
            entranceMachine.setState(this);
            return entranceMachine.alarm();
        }
    },
    UNLOCKED {
        @Override
        public String insertCoin(EntraceMachine entranceMachine) {
            entranceMachine.setState(this);
            return entranceMachine.refund();
        }

        @Override
        public String pass(EntraceMachine entranceMachine) {
            entranceMachine.setState(LOCKED);
            return entranceMachine.close();
        }
    };

    public abstract String insertCoin(EntraceMachine entranceMachine);

    public abstract String pass(EntraceMachine entranceMachine);
}
