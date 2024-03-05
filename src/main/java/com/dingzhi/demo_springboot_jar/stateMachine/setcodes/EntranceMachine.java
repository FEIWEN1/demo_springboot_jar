package com.dingzhi.demo_springboot_jar.stateMachine.setcodes;

import com.dingzhi.demo_springboot_jar.stateMachine.Action;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 枚举所有当前状态、动作的组合，每种组合注入下一个状态和对应的操作
 * 逻辑更加集中
 * @author feiwen
 * @date 2024/3/5
 */
@Data
public class EntranceMachine {
    //定义每一种流转链条的实体 放到集合里面
    List<EntranceMachineTransaction> entranceMachineTransactionList = Arrays.asList(
            EntranceMachineTransaction.builder()
                    .currentState(EntranceMachineState.LOCKED)
                    .action(Action.INSERT_COIN)
                    .nextState(EntranceMachineState.UNLOCKED)
                    .event(new OpenEvent())
                    .build(),
            EntranceMachineTransaction.builder()
                    .currentState(EntranceMachineState.LOCKED)
                    .action(Action.PASS)
                    .nextState(EntranceMachineState.LOCKED)
                    .event(new AlarmEvent())
                    .build(),
            EntranceMachineTransaction.builder()
                    .currentState(EntranceMachineState.UNLOCKED)
                    .action(Action.PASS)
                    .nextState(EntranceMachineState.LOCKED)
                    .event(new CloseEvent())
                    .build(),
            EntranceMachineTransaction.builder()
                    .currentState(EntranceMachineState.UNLOCKED)
                    .action(Action.INSERT_COIN)
                    .nextState(EntranceMachineState.UNLOCKED)
                    .event(new RefundEvent())
                    .build()
    );

    private EntranceMachineState state;

    public EntranceMachine(EntranceMachineState state) {
        setState(state);
    }

    /**
     * 执行状态机 先初始化状态机的状态值 执行状态机方法传入动作
     * @param action
     * @return
     */
    public String execute(Action action) {
        Optional<EntranceMachineTransaction> transactionOptional = entranceMachineTransactionList
                .stream()
                .filter(transaction ->
                        transaction.getAction().equals(action) && transaction.getCurrentState().equals(state))
                .findFirst();

        if (!transactionOptional.isPresent()) {
            throw new RuntimeException();
        }
        //根据当前状态和动作获取状态流转实体

        EntranceMachineTransaction transaction = transactionOptional.get();
        setState(transaction.getNextState());
        return transaction.getEvent().execute();
    }
}
