package com.dingzhi.demo_springboot_jar.stateMachine.switchCode;

import com.dingzhi.demo_springboot_jar.stateMachine.Action;
import lombok.Data;

import java.util.Objects;

/**
 * 完全通过代码逻辑分支 罗列出每一种逻辑 会出现大量重复代码
 * @author feiwen
 * @date 2024/3/5
 */
@Data
public class EntranceMachine {
    private EntranceMachineState state;

    public EntranceMachine(EntranceMachineState state) {
        this.state = state;
    }

    public String execute(Action action) {
        if (Objects.isNull(action)) {
            throw new RuntimeException();
        }

        if (EntranceMachineState.LOCKED.equals(state)) {
            switch (action) {
                case INSERT_COIN:
                    setState(EntranceMachineState.UNLOCKED);
                    return open();
                case PASS:
                    return alarm();
            }
        }

        if (EntranceMachineState.UNLOCKED.equals(state)) {
            switch (action) {
                case PASS:
                    setState(EntranceMachineState.LOCKED);
                    return close();
                case INSERT_COIN:
                    return refund();
            }
        }
        return null;
    }

    private String refund() {
        return "refund";
    }

    private String close() {
        return "closed";
    }

    private String alarm() {
        return "alarm";
    }

    private String open() {
        return "opened";
    }
}
