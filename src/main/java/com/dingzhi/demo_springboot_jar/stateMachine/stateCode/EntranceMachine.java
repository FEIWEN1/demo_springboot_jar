package com.dingzhi.demo_springboot_jar.stateMachine.stateCode;

import com.dingzhi.demo_springboot_jar.stateMachine.Action;

import java.util.Objects;

/**
 * @author feiwen
 * @date 2024/3/5
 */
public class EntranceMachine {
    private EntranceMachineState locked = new LockedEntranceMachineState();

    private EntranceMachineState unlocked = new UnlockedEntranceMachineState();

    private EntranceMachineState state;

    public EntranceMachine(EntranceMachineState state) {
        this.state = state;
    }

    /**
     * 注入当前状态 输入动作返回下一状态
     * @param action
     * @return
     */
    public String execute(Action action) {
        if (Objects.isNull(action)) {
            throw new RuntimeException();
        }

        if (Action.PASS.equals(action)) {
            return state.pass(this);
        }

        return state.insertCoin(this);
    }

    public boolean isUnlocked() {
        return state == unlocked;
    }

    public boolean isLocked() {
        return state == locked;
    }

    public String open() {
        setState(unlocked);
        return "opened";
    }

    public String alarm() {
        setState(locked);
        return "alarm";
    }

    public String refund() {
        setState(unlocked);
        return "refund";
    }

    public String close() {
        setState(locked);
        return "closed";
    }

    private void setState(EntranceMachineState state) {
        this.state = state;
    }
}
