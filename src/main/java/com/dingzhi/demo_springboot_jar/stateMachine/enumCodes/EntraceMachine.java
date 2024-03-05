package com.dingzhi.demo_springboot_jar.stateMachine.enumCodes;

import lombok.Data;

import java.util.Objects;

/**
 * @author feiwen
 * @date 2024/3/5
 */
@Data
public class EntraceMachine {
    private EntranceMachineState state;

    public EntraceMachine(EntranceMachineState state) {
        setState(state);
    }

    public String execute(Action action) {
        if (Objects.isNull(action)) {
            throw new RuntimeException();
        }

        return action.execute(this, state);
    }

    public String open() {
        return "opened";
    }

    public String alarm() {
        return "alarm";
    }

    public String refund() {
        return "refund";
    }

    public String close() {
        return "closed";
    }
}
